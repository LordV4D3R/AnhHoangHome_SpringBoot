package forty3.anhhoanghome.domain.user.auth;

import java.util.regex.Pattern;

/**
 * Public login/display identifier.
 */
public record Username(String value) {

    private static final Pattern USERNAME_PATTERN =
            Pattern.compile("^[a-zA-Z0-9._]{3,30}$");

    public Username {
        if (value == null || !USERNAME_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException(
                    "Username must be 3–30 characters and contain only letters, numbers, '.' or '_'"
            );
        }
    }
}
