package pl.mateuszwarzyc.sr.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mateuszwarzyc.sr.persistence.entities.Bookmark;

import java.util.Collection;

/**
 * Created by mateusz-warzyc.
 */
@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    Collection<Bookmark> findByAccountUsername(String username);
}
