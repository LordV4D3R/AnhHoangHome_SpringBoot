package forty3.anhhoanghome.application.auth;

/**
 * Application-level exceptions for auth use-cases.
 * Keep them here (not in domain) because they relate to flows like login/register.
 */
public final class AuthExceptions {
    private AuthExceptions() {}

    public static class DuplicateEmailException extends RuntimeException {
        public DuplicateEmailException(String message) { super(message); }
    }

    public static class DuplicateUsernameException extends RuntimeException {
        public DuplicateUsernameException(String message) { super(message); }
    }

    public static class InvalidCredentialsException extends RuntimeException {
        public InvalidCredentialsException(String message) { super(message); }
    }

    public static class UserDisabledException extends RuntimeException {
        public UserDisabledException(String message) { super(message); }
    }
}
