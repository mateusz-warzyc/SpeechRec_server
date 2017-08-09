package pl.mateuszwarzyc.sr.services;

import pl.mateuszwarzyc.sr.persistence.entities.IsAlive;

import java.util.List;

/**
 * Created by mateusz-warzyc.
 */
public interface IIsAliveService {

    List<IsAlive> getAllIsAliveEntries();

    void createNewIsAliveCheck();
}
