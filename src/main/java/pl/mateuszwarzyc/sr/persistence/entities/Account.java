package pl.mateuszwarzyc.sr.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mateusz-warzyc.
 */
@Entity
public class Account
{
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private Set<Bookmark> bookmarks = new HashSet<>();

    @JsonIgnore
    private String password;

    private String username;

    public Account(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public Account() {
        // jpa only
    }

    public Set<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(Set<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != null ? !id.equals(account.id) : account.id != null) return false;
        if (bookmarks != null ? !bookmarks.equals(account.bookmarks) : account.bookmarks != null) return false;
        if (password != null ? !password.equals(account.password) : account.password != null) return false;
        return username != null ? username.equals(account.username) : account.username == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (bookmarks != null ? bookmarks.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", bookmarks=" + bookmarks +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
