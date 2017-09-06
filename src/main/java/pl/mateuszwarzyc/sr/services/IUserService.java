package pl.mateuszwarzyc.sr.services;

import pl.mateuszwarzyc.sr.persistence.entities.User;

import java.util.Optional;

/**
 * Created by mateusz-warzyc.
 */
public interface IUserService {

    public Optional<User> getByUsername(String username);
}
