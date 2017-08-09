package pl.mateuszwarzyc.sr.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.mateuszwarzyc.sr.persistence.entities.IsAlive;
import pl.mateuszwarzyc.sr.services.IIsAliveService;

import java.util.List;

/**
 * Created by mateusz-warzyc.
 */
@RestController
@RequestMapping("/isAlive")
public class IsAliveController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IsAliveController.class);

    @Autowired
    private IIsAliveService isAliveService;

    @RequestMapping(method = RequestMethod.GET)
    public List<IsAlive> getAllIsAliveEntities() {
        LOGGER.debug("Request for all isAlive entries received..");
        return isAliveService.getAllIsAliveEntries();
    }
}
