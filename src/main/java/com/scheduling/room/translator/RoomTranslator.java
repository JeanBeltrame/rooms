package com.scheduling.room.translator;

import com.scheduling.model.Room;
import com.scheduling.room.dto.RoomDTO;
import org.springframework.stereotype.Component;


@Component
public class RoomTranslator {

    public RoomDTO toDTO(Room entity) {
        RoomDTO dto = new RoomDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public Room toEntity(RoomDTO room) {
        Room entity = new Room();
        entity.setId(room.getId());
        entity.setName(room.getName());
        entity.setDescription(room.getDescription());
        return entity;
    }
}
