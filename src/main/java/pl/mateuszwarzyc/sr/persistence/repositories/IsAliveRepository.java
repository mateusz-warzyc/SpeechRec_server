package pl.mateuszwarzyc.sr.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mateuszwarzyc.sr.persistence.entities.IsAlive;

/**
 * Created by mateusz-warzyc.
 */
@Repository
public interface IsAliveRepository extends JpaRepository<IsAlive, Long> {
}
