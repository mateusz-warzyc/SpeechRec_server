package pl.mateuszwarzyc.sr.common;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by mateusz-warzyc.
 */
public enum  ErrorCode {
    GLOBAL(2),

    AUTHENTICATION(10), JWT_TOKEN_EXPIRED(11);

    private int errorCode;

    private ErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @JsonValue
    public int getErrorCode() {
        return errorCode;
    }
}
