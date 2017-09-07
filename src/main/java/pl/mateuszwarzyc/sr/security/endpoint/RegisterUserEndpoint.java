package pl.mateuszwarzyc.sr.security.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.mateuszwarzyc.sr.services.IUserService;
import pl.mateuszwarzyc.sr.shared.dto.RegisterUserDTO;

import javax.validation.Valid;

/**
 * Created by mateusz-warzyc.
 */
@Validated
@RestController
public class RegisterUserEndpoint {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterUserEndpoint.class);
    private final IUserService userService;

    @Autowired
    public RegisterUserEndpoint(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/api/auth/register", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Valid @RequestBody RegisterUserDTO registerDto) {
        this.userService.createUser(registerDto);
        LOGGER.info("New user registered successfully..");
    }
}
