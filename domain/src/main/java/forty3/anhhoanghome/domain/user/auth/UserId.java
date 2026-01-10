package forty3.anhhoanghome.domain.user.auth;

import java.util.UUID;

/**
 * Strongly-typed identity for User.
 */
public record UserId(UUID value) {

    public UserId {
        if (value == null) {
            throw new IllegalArgumentException("UserId cannot be null");
        }
    }
}
