package com.scheduling.room.usecase;

import com.scheduling.room.dto.RoomDTO;
import com.scheduling.room.service.RoomService;
import com.scheduling.room.validator.RoomValidator;
import org.springframework.stereotype.Component;

import javax.management.InstanceAlreadyExistsException;

@Component
public class CreateRoomUseCase {

    private final RoomValidator roomValidator;
    private final RoomService roomService;

    public CreateRoomUseCase(RoomValidator roomValidator, RoomService roomService) {
        this.roomValidator = roomValidator;
        this.roomService = roomService;
    }

    public RoomDTO execute(RoomDTO room) throws InstanceAlreadyExistsException {
        roomValidator.validateIfNotExists(room);
        return roomService.create(room);
    }
}
