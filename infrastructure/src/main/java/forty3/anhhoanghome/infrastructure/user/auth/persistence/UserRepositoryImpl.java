package forty3.anhhoanghome.infrastructure.user.auth.persistence;

import forty3.anhhoanghome.domain.user.auth.*;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final SpringDataUserRepository jpa;

    public UserRepositoryImpl(SpringDataUserRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public boolean existsByEmail(Email email) {
        return jpa.existsByEmail(email.value());
    }

    @Override
    public boolean existsByUsername(Username username) {
        return jpa.existsByUsername(username.value());
    }

    @Override
    public Optional<User> findByEmail(Email email) {
        return jpa.findByEmail(email.value()).map(this::toDomain);
    }

    @Override
    public Optional<User> findByUsername(Username username) {
        return jpa.findByUsername(username.value()).map(this::toDomain);
    }

    @Override
    public User save(User user) {
        UserJpaEntity saved = jpa.save(toJpa(user));
        return toDomain(saved);
    }

    private UserJpaEntity toJpa(User user) {
        return UserJpaEntity.of(
                user.id().value(),
                user.fullName().value(),
                user.username().value(),
                user.email().value(),
                user.passwordHash().value(),
                user.role().name(),
                user.status().name(),
                null, // address (add when your domain exposes it)
                null, // phoneNumber
                null, // citizenId
                null  // imageUrl
        );
    }

    private User toDomain(UserJpaEntity e) {
        // IMPORTANT:
        // Your domain User currently has a private constructor and a register(...) factory,
        // which forces ACTIVE/USER and sets fields.
        // For rehydration from DB, you should add a domain factory like:
        //   User.rehydrate(...)
        // For now, we can only create via register(...) and accept defaults.

        User u = User.register(
                new UserId(e.getId()),
                new FullName(e.getFullName()),
                new Username(e.getUsername()),
                new Email(e.getEmail()),
                new PasswordHash(e.getPasswordHash())
        );

        // If you want DB to control role/status, we must support rehydrate() in domain.
        // We'll do that in the next micro-step.

        return u;
    }
}
