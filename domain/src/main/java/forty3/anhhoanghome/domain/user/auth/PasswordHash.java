package forty3.anhhoanghome.domain.user.auth;

public record PasswordHash(String value) {

    public PasswordHash {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Password hash cannot be empty");
        }

        // Defensive: BCrypt hashes start with $2
        if (!value.startsWith("$2")) {
            throw new IllegalArgumentException("Invalid password hash format");
        }
    }
}
