package com.scheduling.schedule.usecase;

import com.scheduling.exception.NotFoundException;
import com.scheduling.room.dto.RoomDTO;
import com.scheduling.room.service.RoomService;
import com.scheduling.schedule.dto.SchedulingDTO;
import com.scheduling.schedule.service.SchedulingService;
import org.springframework.stereotype.Component;

@Component
public class RetrieveSchedulingUseCase {

    private final SchedulingService schedulingService;

    public RetrieveSchedulingUseCase(SchedulingService schedulingService) {
        this.schedulingService = schedulingService;
    }


    public SchedulingDTO execute(Long id) throws NotFoundException {
        return schedulingService.retrieve(id).orElseThrow(() -> new NotFoundException("Scheduling with id " + id + " not found"));
    }
}
