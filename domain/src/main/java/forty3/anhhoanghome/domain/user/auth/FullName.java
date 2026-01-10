package forty3.anhhoanghome.domain.user.auth;

public record FullName(String value) {

    public FullName {
        if (value == null || value.trim().length() < 2) {
            throw new IllegalArgumentException("Full name must be at least 2 characters");
        }

        value = value.trim();
    }
}
