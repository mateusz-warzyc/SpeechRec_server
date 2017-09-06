package pl.mateuszwarzyc.sr.security.exceptions;

import org.springframework.security.core.AuthenticationException;
import pl.mateuszwarzyc.sr.security.model.token.JwtToken;

/**
 * Created by mateusz-warzyc.
 */
public class JwtExpiredTokenException extends AuthenticationException {
    private static final long serialVersionUID = 8670545506375708419L;

    private JwtToken token;

    public JwtExpiredTokenException(String msg) {
        super(msg);
    }

    public JwtExpiredTokenException(JwtToken token, String msg, Throwable t) {
        super(msg, t);
        this.token = token;
    }

    public String token() {
        return this.token.getToken();
    }

}
