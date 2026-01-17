package forty3.anhhoanghome.application.auth;

/**
 * Input data for user registration use-case.
 * This is NOT a REST DTO.
 */
public record RegisterCommand(
        String fullName,
        String username,
        String email,
        String rawPassword
) {}
