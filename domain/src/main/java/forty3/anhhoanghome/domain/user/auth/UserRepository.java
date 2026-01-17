package forty3.anhhoanghome.domain.user.auth;

import java.util.Optional;

public interface UserRepository {
    boolean existsByEmail(Email email);
    boolean existsByUsername(Username username);

    Optional<User> findByEmail(Email email);
    Optional<User> findByUsername(Username username);

    User save(User user);
}
