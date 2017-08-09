package pl.mateuszwarzyc.sr.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mateuszwarzyc.sr.persistence.entities.IsAlive;
import pl.mateuszwarzyc.sr.persistence.repositories.IsAliveRepository;
import pl.mateuszwarzyc.sr.services.IIsAliveService;
import pl.mateuszwarzyc.sr.shared.dto.IsAliveDTO;
import pl.mateuszwarzyc.sr.shared.mappers.IsAliveMapper;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;

/**
 * Created by mateusz-warzyc.
 */
@Service
public class IsAliveService implements IIsAliveService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IsAliveService.class);

    @Autowired
    private IsAliveRepository repo;

    @Autowired
    private IsAliveMapper isAliveMapper;

    @Override
    @Transactional
    public List<IsAliveDTO> getAllIsAliveEntries() {
        LOGGER.debug("Service for fetching all entries for isAlive called..");
        createNewIsAliveCheck();
        return isAliveMapper.isAliveListToIsAliveDTOList(repo.findAll());
    }

    @Override
    public void createNewIsAliveCheck() {
        LOGGER.debug("Creating new isAlive entry..");
        IsAlive isAliveEntry = new IsAlive();
        isAliveEntry.setDescription("Checking if app is still working fine");
        isAliveEntry.setTimestamp(Calendar.getInstance());
        repo.saveAndFlush(isAliveEntry);

    }
}
