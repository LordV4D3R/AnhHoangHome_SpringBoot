package forty3.anhhoanghome.application.auth;

public record UserResult(
        String userId,
        String email,
        String username,
        String role,
        String status
) {}
