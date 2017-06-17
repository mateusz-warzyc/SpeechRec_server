package pl.mateuszwarzyc.sr.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by mateusz-warzyc.
 */
@Entity
public class Bookmark {

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @ManyToOne
    private Account account;
    private String url;
    private String description;

    public Bookmark(Account account, String url, String description) {
        this.account = account;
        this.url = url;
        this.description = description;
    }

    public Bookmark() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bookmark bookmark = (Bookmark) o;

        if (id != null ? !id.equals(bookmark.id) : bookmark.id != null) return false;
        if (account != null ? !account.equals(bookmark.account) : bookmark.account != null) return false;
        if (url != null ? !url.equals(bookmark.url) : bookmark.url != null) return false;
        return description != null ? description.equals(bookmark.description) : bookmark.description == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Bookmark{" +
                "id=" + id +
                ", account=" + account +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
