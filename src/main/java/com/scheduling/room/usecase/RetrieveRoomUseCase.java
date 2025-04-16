package com.scheduling.room.usecase;

import com.scheduling.exception.NotFoundException;
import com.scheduling.room.dto.RoomDTO;
import com.scheduling.room.service.RoomService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RetrieveRoomUseCase {

    private final RoomService roomService;

    public RetrieveRoomUseCase(RoomService roomService) {
        this.roomService = roomService;
    }

    public RoomDTO execute(Long id) throws NotFoundException {
        return roomService.retrieve(id).orElseThrow(() -> new NotFoundException("Room with id " + id + " not found"));
    }
}
