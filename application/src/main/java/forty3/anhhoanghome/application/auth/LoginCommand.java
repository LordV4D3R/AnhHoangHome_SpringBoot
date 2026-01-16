package forty3.anhhoanghome.application.auth;

public record LoginCommand(
        String email,
        String rawPassword
) {}
