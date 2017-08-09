package pl.mateuszwarzyc.sr.services;

import pl.mateuszwarzyc.sr.shared.dto.IsAliveDTO;

import java.util.List;

/**
 * Created by mateusz-warzyc.
 */
public interface IIsAliveService {

    List<IsAliveDTO> getAllIsAliveEntries();

    void createNewIsAliveCheck();
}
