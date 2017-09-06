package pl.mateuszwarzyc.sr.security.auth.jwt.verifier;

import org.springframework.stereotype.Component;

/**
 * Created by mateusz-warzyc.
 */
@Component
public class BloomTokenVerifier implements TokenVerifier {

    @Override
    public boolean verify(String jti) {
        return true;
    }
}
