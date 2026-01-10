package forty3.anhhoanghome.domain.user.auth;
import java.util.regex.Pattern;

public record Email(String value) {
    private static final Pattern EMAIL =
            Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");

    public Email {
        if (value == null || value.isBlank() || !EMAIL.matcher(value).matches()) {
            throw new IllegalArgumentException("Invalid email");
        }
        value = value.toLowerCase();
    }
}
