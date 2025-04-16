package com.scheduling.schedule.usecase;

import com.scheduling.room.dto.RoomDTO;
import com.scheduling.room.exception.SchedulingConflictException;
import com.scheduling.room.service.RoomService;
import com.scheduling.room.validator.RoomValidator;
import com.scheduling.schedule.dto.SchedulingDTO;
import com.scheduling.schedule.service.SchedulingService;
import com.scheduling.schedule.validator.SchedulingValidator;
import org.springframework.stereotype.Component;

import javax.management.InstanceAlreadyExistsException;

@Component
public class CreateSchedulingUseCase {

    private final SchedulingValidator schedulingValidator;
    private final SchedulingService schedulingService;

    public CreateSchedulingUseCase(SchedulingValidator schedulingValidator, SchedulingService schedulingService) {
        this.schedulingValidator = schedulingValidator;
        this.schedulingService = schedulingService;
    }

    public SchedulingDTO execute(SchedulingDTO schedulingDTO) throws SchedulingConflictException {
        schedulingValidator.validateStartAndEndTimes(schedulingDTO.getStartTime(), schedulingDTO.getEndTime());
        schedulingValidator.validateIfRoomExists(schedulingDTO.getRoomId());
        schedulingValidator.validateNoConflict(schedulingDTO);
        return schedulingService.create(schedulingDTO);
    }
}
