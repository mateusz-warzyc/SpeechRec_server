package pl.mateuszwarzyc.sr.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.mateuszwarzyc.sr.persistence.entities.User;

import java.util.Optional;


/**
 * Created by mateusz-warzyc.
 */
public interface IUserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u left join fetch u.roles ró where u.username=:username")
    public Optional<User> findByUsername(@Param("username") String username);
}
