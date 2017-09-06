package pl.mateuszwarzyc.sr.security.model.token;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.jsonwebtoken.Claims;

/**
 * Created by mateusz-warzyc.
 */
public final class AccessJwtToken implements JwtToken {

    private final String rawToken;

    @JsonIgnore
    private Claims claims;

    protected AccessJwtToken(final String rawToken, final Claims claims) {
        this.rawToken = rawToken;
        this.claims = claims;
    }

    @Override
    public String getToken() {
        return this.rawToken;
    }

    public Claims getClaims() {
        return this.claims;
    }
}
