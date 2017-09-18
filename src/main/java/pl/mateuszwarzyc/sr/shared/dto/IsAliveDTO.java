package pl.mateuszwarzyc.sr.shared.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * Created by mateusz-warzyc.
 */
public class IsAliveDTO implements Serializable {
    private static final long serialVersionUID = 1784802261824417432L;

    private String checkDescription;
    private String checkTimestamp;

    public IsAliveDTO() {}

    public IsAliveDTO(String checkDescription, String checkTimestamp) {
        this.checkDescription = checkDescription;
        this.checkTimestamp = checkTimestamp;
    }

    public String getCheckDescription() {
        return checkDescription;
    }

    public void setCheckDescription(String checkDescription) {
        this.checkDescription = checkDescription;
    }

    public String getCheckTimestamp() {
        return checkTimestamp;
    }

    public void setCheckTimestamp(String checkTimestamp) {
        this.checkTimestamp = checkTimestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        IsAliveDTO that = (IsAliveDTO) o;

        return new EqualsBuilder()
                .append(checkDescription, that.checkDescription)
                .append(checkTimestamp, that.checkTimestamp)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(checkDescription)
                .append(checkTimestamp)
                .toHashCode();
    }
}
