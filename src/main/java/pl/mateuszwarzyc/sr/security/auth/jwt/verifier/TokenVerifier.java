package pl.mateuszwarzyc.sr.security.auth.jwt.verifier;

/**
 * Created by mateusz-warzyc.
 */
public interface TokenVerifier {
    public boolean verify(String jti);
}
