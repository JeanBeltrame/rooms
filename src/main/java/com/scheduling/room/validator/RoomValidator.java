package com.scheduling.room.validator;

import com.scheduling.room.dto.RoomDTO;
import com.scheduling.room.service.RoomService;
import org.springframework.stereotype.Component;

import javax.management.InstanceAlreadyExistsException;

@Component
public class RoomValidator {

    private final RoomService roomService;

    public RoomValidator(RoomService roomService) {
        this.roomService = roomService;
    }

    public void validateIfNotExists(RoomDTO room) throws InstanceAlreadyExistsException {
        if(roomService.retrieve(room.getName()).isPresent()) {
            throw new InstanceAlreadyExistsException("Room with name " + room.getName() + " already exists");
        }
    }

}
