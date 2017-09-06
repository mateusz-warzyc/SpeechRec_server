package pl.mateuszwarzyc.sr.security.exceptions;

import org.springframework.security.authentication.AuthenticationServiceException;

/**
 * Created by mateusz-warzyc.
 */
public class AuthMethodNotSupportedException extends AuthenticationServiceException {

    private static final long serialVersionUID = 2489270640153947708L;

    public AuthMethodNotSupportedException(String msg) {
        super(msg);
    }
}
