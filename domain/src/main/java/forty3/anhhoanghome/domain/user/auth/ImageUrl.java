package forty3.anhhoanghome.domain.user.auth;

import java.net.URI;

/**
 * URL to user's profile image.
 */
public record ImageUrl(String value) {

    public ImageUrl {
        try {
            URI.create(value);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid image URL");
        }
    }
}
