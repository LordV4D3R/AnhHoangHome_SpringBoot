package forty3.anhhoanghome.domain.user.auth;

/**
 * Physical address.
 */
public record Address(String value) {

    public Address {
        if (value == null || value.trim().length() < 5) {
            throw new IllegalArgumentException("Address must be at least 5 characters");
        }

        value = value.trim();
    }
}