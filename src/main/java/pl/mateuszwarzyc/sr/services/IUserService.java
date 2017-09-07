package pl.mateuszwarzyc.sr.services;

import pl.mateuszwarzyc.sr.persistence.entities.User;
import pl.mateuszwarzyc.sr.shared.dto.RegisterUserDTO;

import java.util.Optional;

/**
 * Created by mateusz-warzyc.
 */
public interface IUserService {

    Optional<User> getByUsername(String username);

    void createUser(RegisterUserDTO user);
}
