package pl.mateuszwarzyc.sr.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mateuszwarzyc.sr.persistence.entities.User;
import pl.mateuszwarzyc.sr.persistence.repositories.IUserRepository;
import pl.mateuszwarzyc.sr.services.IUserService;

import java.util.Optional;

/**
 * Created by mateusz-warzyc.
 */
@Service
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    public IUserRepository getUserRepository() {
        return userRepository;
    }

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
