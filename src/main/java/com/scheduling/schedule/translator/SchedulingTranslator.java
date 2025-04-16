package com.scheduling.schedule.translator;

import com.scheduling.model.Room;
import com.scheduling.model.Scheduling;
import com.scheduling.schedule.dto.SchedulingDTO;
import org.springframework.stereotype.Component;


@Component
public class SchedulingTranslator {

    public SchedulingDTO toDTO(Scheduling entity) {
        SchedulingDTO dto = new SchedulingDTO();
        dto.setId(entity.getId());
        dto.setRoomId(entity.getRoom().getId());
        dto.setDate(entity.getDate());
        dto.setStartTime(entity.getStartTime());
        dto.setEndTime(entity.getEndTime());
        return dto;
    }

    public Scheduling toEntity(SchedulingDTO dto) {
        Scheduling entity = new Scheduling();
        entity.setId(dto.getId());

        Room room = new Room();
        room.setId(dto.getRoomId());
        entity.setRoom(room);

        entity.setDate(dto.getDate());
        entity.setStartTime(dto.getStartTime());
        entity.setEndTime(dto.getEndTime());
        return entity;
    }
}
