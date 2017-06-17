package pl.mateuszwarzyc.sr.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mateuszwarzyc.sr.persistence.entities.Account;

import java.util.Optional;

/**
 * Created by mateusz-warzyc.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    Optional<Account> findByUsername(String username);
}
