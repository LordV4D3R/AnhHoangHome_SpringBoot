package forty3.anhhoanghome.infrastructure.user.auth.persistence;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_users_email", columnNames = "email"),
                @UniqueConstraint(name = "uk_users_username", columnNames = "username")
        }
)
public class UserJpaEntity {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Column(name = "username", nullable = false, length = 30)
    private String username;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Column(name = "password_hash", nullable = false, length = 100)
    private String passwordHash;

    @Column(name = "role", nullable = false, length = 30)
    private String role;

    @Column(name = "status", nullable = false, length = 30)
    private String status;

    // Optional profile fields (nullable)
    @Column(name = "address")
    private String address;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "citizen_id", length = 20)
    private String citizenId;

    @Column(name = "image_url")
    private String imageUrl;

    protected UserJpaEntity() {
        // JPA requirement
    }

    // --- getters (keep setters minimal; infra only) ---
    public UUID getId() { return id; }
    public String getFullName() { return fullName; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPasswordHash() { return passwordHash; }
    public String getRole() { return role; }
    public String getStatus() { return status; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getCitizenId() { return citizenId; }
    public String getImageUrl() { return imageUrl; }

    // --- builder-like factory for mapping ---
    public static UserJpaEntity of(
            UUID id,
            String fullName,
            String username,
            String email,
            String passwordHash,
            String role,
            String status,
            String address,
            String phoneNumber,
            String citizenId,
            String imageUrl
    ) {
        UserJpaEntity e = new UserJpaEntity();
        e.id = id;
        e.fullName = fullName;
        e.username = username;
        e.email = email;
        e.passwordHash = passwordHash;
        e.role = role;
        e.status = status;
        e.address = address;
        e.phoneNumber = phoneNumber;
        e.citizenId = citizenId;
        e.imageUrl = imageUrl;
        return e;
    }
}
