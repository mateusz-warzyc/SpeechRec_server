package pl.mateuszwarzyc.sr.persistence.entities;

/**
 * Created by mateusz-warzyc.
 */
public enum Role {

    ADMIN,
    MEMBER,
    PREMIUM_MEMBER,
    USER;

    public String authority() {
        return "ROLE_" + this.name();
    }
}
