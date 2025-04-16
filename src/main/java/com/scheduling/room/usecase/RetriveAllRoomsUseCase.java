package com.scheduling.room.usecase;

import com.scheduling.room.dto.RoomDTO;
import com.scheduling.room.service.RoomService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class RetriveAllRoomsUseCase {

    private final RoomService roomService;

    public RetriveAllRoomsUseCase(RoomService roomService) {
        this.roomService = roomService;
    }

    public Page<RoomDTO> execute(Pageable pageable, RoomDTO roomDTOFilter) {
        return roomService.retrieveAll(pageable, roomDTOFilter);
    }
}
