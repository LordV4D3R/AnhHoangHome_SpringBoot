package forty3.anhhoanghome.domain.user.auth;

import java.util.regex.Pattern;

/**
 * Phone number in E.164-like format.
 */
public record PhoneNumber(String value) {

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^\\+?[0-9]{8,15}$");

    public PhoneNumber {
        if (value == null || !PHONE_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("Invalid phone number format");
        }
    }
}
