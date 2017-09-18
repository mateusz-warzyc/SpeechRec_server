package pl.mateuszwarzyc.sr.security.endpoint.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.mateuszwarzyc.sr.security.endpoint.UserEndpoint;

import javax.validation.ConstraintViolationException;
import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mateusz-warzyc.
 */
@ControllerAdvice(basePackageClasses = UserEndpoint.class)
public class UserEndpointErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserEndpointErrorHandler.class);
    private static final String VALIDATION_MESSAGE_TEMPLATE = "Error field: {0} - message: {1}";
    private static final String UNEXPECTED_ERROR_MESSAGE_TEMPLATE = "Unexpected error: {0}";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleValidationErrors(final MethodArgumentNotValidException ex) {
        LOGGER.error("one or some of the parameters is missing, or empty");
        List<String>  errors = ex.getBindingResult().getFieldErrors().stream()
                .map( e -> MessageFormat.format(VALIDATION_MESSAGE_TEMPLATE,e.getField(),e.getDefaultMessage()))
                .collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity handleRequestParamValidationErrors(final ConstraintViolationException ex) {
        LOGGER.error("one or some of the parameters is missing, or empty");
        List<String> errors = ex.getConstraintViolations().stream()
                .map( e -> MessageFormat.format(VALIDATION_MESSAGE_TEMPLATE, e.getPropertyPath(),e.getMessage()))
                .collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity handleDbConstraints(final DataIntegrityViolationException ex) {
        LOGGER.error("Error while persisting new user in DB: {}", ex.getMessage());
        return ResponseEntity.unprocessableEntity().body("Username is already used!");
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(final Exception ex) {
        LOGGER.error("Unexpected error: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(MessageFormat.format(UNEXPECTED_ERROR_MESSAGE_TEMPLATE, ex.getMessage()));
    }

}
