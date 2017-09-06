package pl.mateuszwarzyc.sr.persistence.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mateusz-warzyc.
 */
@Entity
@Table(name = "auth_user_role")
public class UserRole implements Serializable {
    @Embeddable
    public static class Id implements Serializable {
        private static final long serialVersionUID = 9201447050403352411L;

        @Column(name = "auth_user_id")
        protected Long userId;

        @Enumerated(EnumType.STRING)
        protected Role role;

        public Id() {}

        public Id(Long userId, Role role) {
            this.userId = userId;
            this.role = role;
        }
    }

    @EmbeddedId
    Id id = new Id();

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE", insertable = false, updatable = false)
    protected Role role;

    public Role getRole() {
        return role;
    }

}
