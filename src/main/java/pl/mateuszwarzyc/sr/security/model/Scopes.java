package pl.mateuszwarzyc.sr.security.model;

/**
 * Created by mateusz-warzyc.
 */
public enum Scopes {
    REFRESH_TOKEN;

    public String authority() {
        return "ROLE_" + this.name();
    }
}
