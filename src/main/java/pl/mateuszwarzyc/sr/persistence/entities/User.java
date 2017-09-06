package pl.mateuszwarzyc.sr.persistence.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mateusz-warzyc.
 */
@Entity
@Table(name = "auth_user")
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToMany
    @JoinColumn(name = "auth_user_id", referencedColumnName = "ID")
    private List<UserRole> roles;

    public User() {}

    public User(String username, String password, List<UserRole> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<UserRole> getRoles() {
        return roles;
    }
}
