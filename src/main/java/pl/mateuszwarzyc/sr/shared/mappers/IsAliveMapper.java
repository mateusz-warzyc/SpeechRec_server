package pl.mateuszwarzyc.sr.shared.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pl.mateuszwarzyc.sr.persistence.entities.IsAlive;
import pl.mateuszwarzyc.sr.shared.dto.IsAliveDTO;

import java.util.List;

/**
 * Created by mateusz-warzyc.
 */
@Mapper(componentModel = "spring")
public interface IsAliveMapper {

    @Mappings({
            @Mapping(source = "description", target = "checkDescription"),
            @Mapping(source = "timestamp", target = "checkTimestamp",  dateFormat = "dd-MM-yyyy HH:mm:ss")
    })
    IsAliveDTO isAliveToIsALiveDTO(IsAlive isAlive);

    @Mappings({
            @Mapping(source = "checkDescription",target = "description"),
            @Mapping(source = "checkTimestamp",target = "timestamp")
    })
    IsAlive isAliveDTOToIsAlive(IsAliveDTO dto);

    List<IsAliveDTO> isAliveListToIsAliveDTOList(List<IsAlive> isAlives);
    List<IsAlive> isAliveDTOToIsAliveList(List<IsAliveDTO> isAliveDTOS);
}
