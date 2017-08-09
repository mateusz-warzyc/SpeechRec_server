package pl.mateuszwarzyc.sr.shared.dto;

/**
 * Created by mateusz-warzyc.
 */
public class IsAliveDTO {

    private String checkDescription;

    private String checkTimestamp;

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
}
