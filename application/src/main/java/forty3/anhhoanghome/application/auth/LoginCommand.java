package forty3.anhhoanghome.application.auth;

public record LoginCommand(
        String identifier,  // email OR username
        String rawPassword
) {}
