package forty3.anhhoanghome.domain.user.auth;

public class User {

    private final UserId id;
    private FullName fullName;
    private Username username;
    private Email email;
    private PasswordHash passwordHash;
    private Address address;
    private PhoneNumber phoneNumber;
    private CitizenId citizenId;
    private ImageUrl imageUrl;
    private Role role;
    private UserStatus status;

    private User(
            UserId id,
            FullName fullName,
            Username username,
            Email email,
            PasswordHash passwordHash,
            Address address,
            PhoneNumber phoneNumber,
            CitizenId citizenId,
            ImageUrl imageUrl,
            Role role,
            UserStatus status
    ) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.citizenId = citizenId;
        this.imageUrl = imageUrl;
        this.role = role;
        this.status = status;
    }

    /** Business creation rule */
    public static User register(
            UserId id,
            FullName fullName,
            Username username,
            Email email,
            PasswordHash passwordHash
    ) {
        return new User(
                id,
                fullName,
                username,
                email,
                passwordHash,
                null,
                null,
                null,
                null,
                Role.USER,
                UserStatus.ACTIVE
        );
    }

    /** Business behavior */
    public void disable() {
        if (status == UserStatus.DISABLED) return;
        status = UserStatus.DISABLED;
    }

    public UserId id() { return id; }
    public FullName fullName() { return fullName; }
    public Username username() { return username; }
    public Email email() { return email; }
    public PasswordHash passwordHash() { return passwordHash; }
    public Role role() { return role; }
    public UserStatus status() { return status; }
}

