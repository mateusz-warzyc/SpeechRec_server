package pl.mateuszwarzyc.sr.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mateuszwarzyc.sr.persistence.entities.Role;
import pl.mateuszwarzyc.sr.persistence.entities.User;
import pl.mateuszwarzyc.sr.persistence.entities.UserRole;
import pl.mateuszwarzyc.sr.persistence.repositories.IUserRepository;
import pl.mateuszwarzyc.sr.services.IUserService;
import pl.mateuszwarzyc.sr.shared.dto.RegisterUserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by mateusz-warzyc.
 */
@Service
public class UserService implements IUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final IUserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UserService(IUserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public void createUser(RegisterUserDTO user) {
        List<UserRole> roles = new ArrayList<>();
        UserRole role = new UserRole(Role.USER);
        roles.add(role);
        User userToSave = new User();
        userToSave.setUsername(user.getEmail());
        userToSave.setPassword(encoder.encode(user.getPassword()));
        userToSave.setRoles(roles);
        role.setUser(userToSave);
        User savedUser = this.userRepository.saveAndFlush(userToSave);
        LOGGER.debug("New user with username {} and roles: {} saved..",savedUser.getUsername(), savedUser.getRoles());
    }
}
