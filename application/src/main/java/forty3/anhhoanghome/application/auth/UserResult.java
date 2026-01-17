package forty3.anhhoanghome.application.auth;

/**
 * Output data after successful registration.
 */
public record UserResult(
        String userId,
        String email,
        String username,
        String role,
        String status
) {}
