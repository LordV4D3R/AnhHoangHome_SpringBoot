package forty3.anhhoanghome.application.auth;

import forty3.anhhoanghome.domain.user.auth.*;

import java.util.UUID;

import static forty3.anhhoanghome.application.auth.AuthExceptions.*;

public class RegisterUserUseCase {

    private final UserRepository userRepository;
    private final PasswordHasher passwordHasher;

    public RegisterUserUseCase(UserRepository userRepository, PasswordHasher passwordHasher) {
        this.userRepository = userRepository;
        this.passwordHasher = passwordHasher;
    }

    public UserResult execute(RegisterCommand command) {
        FullName fullName = new FullName(command.fullName());
        Username username = new Username(command.username());
        Email email = new Email(command.email());

        if (userRepository.existsByEmail(email)) {
            throw new DuplicateEmailException("Email already exists");
        }
        if (userRepository.existsByUsername(username)) {
            throw new DuplicateUsernameException("Username already exists");
        }

        String hashed = passwordHasher.hash(command.rawPassword());
        PasswordHash passwordHash = new PasswordHash(hashed);

        User user = User.register(
                new UserId(UUID.randomUUID()),
                fullName,
                username,
                email,
                passwordHash
        );

        User saved = userRepository.save(user);

        return new UserResult(
                saved.id().value().toString(),
                saved.email().value(),
                saved.username().value(),
                saved.role().name(),
                saved.status().name()
        );
    }
}
