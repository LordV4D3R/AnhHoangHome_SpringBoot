package forty3.anhhoanghome.application.auth;

import forty3.anhhoanghome.domain.user.auth.User;

public interface TokenService {
    String createAccessToken(User user);
}
