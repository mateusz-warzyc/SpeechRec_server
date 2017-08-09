package pl.mateuszwarzyc.sr.persistence.entities;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by mateusz-warzyc.
 */
@Entity
@Table(name = "INFO_IS_ALIVE_TABLE")
public class IsAlive implements Serializable {

    private static final long serialVersionUID = -4852478994224907435L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Calendar timestamp;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Calendar timestamp) {
        this.timestamp = timestamp;
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
        IsAlive isAlive = (IsAlive) o;
        return new EqualsBuilder()
                .append(id, isAlive.id)
                .append(timestamp, isAlive.timestamp)
                .append(description, isAlive.description)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(timestamp)
                .append(description)
                .toHashCode();
    }
}
