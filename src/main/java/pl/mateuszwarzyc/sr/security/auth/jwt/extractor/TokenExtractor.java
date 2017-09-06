package pl.mateuszwarzyc.sr.security.auth.jwt.extractor;

/**
 * Created by mateusz-warzyc.
 */
public interface TokenExtractor {
    String extract(String payload);
}
