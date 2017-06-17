package pl.mateuszwarzyc.sr.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by mateusz-warzyc.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String userId) {
        super("Could not find user'" + userId + "'.");
    }
}
