package forty3.anhhoanghome.application.auth;

import forty3.anhhoanghome.domain.user.auth.*;

import java.util.Optional;

import static forty3.anhhoanghome.application.auth.AuthExceptions.*;

public class LoginUseCase {

    private final UserRepository userRepository;
    private final PasswordHasher passwordHasher;
    private final TokenService tokenService;

    public LoginUseCase(UserRepository userRepository, PasswordHasher passwordHasher, TokenService tokenService) {
        this.userRepository = userRepository;
        this.passwordHasher = passwordHasher;
        this.tokenService = tokenService;
    }

    public TokenResult execute(LoginCommand command) {
        User user = findUserByIdentifier(command.identifier())
                .orElseThrow(() -> new InvalidCredentialsException("Invalid credentials"));

        if (user.status() == UserStatus.DISABLED) {
            throw new UserDisabledException("User is disabled");
        }

        boolean ok = passwordHasher.matches(command.rawPassword(), user.passwordHash().value());
        if (!ok) {
            throw new InvalidCredentialsException("Invalid credentials");
        }

        String token = tokenService.createAccessToken(user);
        return new TokenResult(token);
    }

    private Optional<User> findUserByIdentifier(String identifier) {
        // 1) Try as Email (if identifier is not a valid email, Email(value) will throw)
        try {
            Email email = new Email(identifier);
            return userRepository.findByEmail(email);
        } catch (IllegalArgumentException ignored) {
            // not an email -> continue
        }

        // 2) Try as Username (Username(value) will validate)
        try {
            Username username = new Username(identifier);
            return userRepository.findByUsername(username);
        } catch (IllegalArgumentException ignored) {
            // neither valid email nor username -> no match
        }

        return Optional.empty();
    }
}
