package forty3.anhhoanghome.application.auth;

public record RegisterCommand(
        String email,
        String username,
        String rawPassword
) {}
