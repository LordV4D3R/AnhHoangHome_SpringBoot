package forty3.anhhoanghome.domain.user.auth;

/**
 * Government-issued citizen identification number.
 */
public record CitizenId(String value) {

    public CitizenId {
        if (value == null || !value.matches("\\d{9,12}")) {
            throw new IllegalArgumentException("Citizen ID must be 9–12 digits");
        }
    }
}