package com.scheduling.schedule.validator;

import com.scheduling.model.Room;
import com.scheduling.room.dto.RoomDTO;
import com.scheduling.room.exception.SchedulingConflictException;
import com.scheduling.room.repository.RoomRepository;
import com.scheduling.room.service.RoomService;
import com.scheduling.schedule.dto.SchedulingDTO;
import com.scheduling.schedule.repository.SchedulingRepository;
import org.springframework.stereotype.Component;

import javax.management.InstanceAlreadyExistsException;
import java.time.LocalTime;
import java.util.Optional;

@Component
public class SchedulingValidator {

    private final RoomRepository roomRepository;
    private final SchedulingRepository schedulingRepository;

    public SchedulingValidator(RoomRepository roomRepository, SchedulingRepository schedulingRepository) {
        this.roomRepository = roomRepository;
        this.schedulingRepository = schedulingRepository;
    }

    public void validateNoConflict(SchedulingDTO dto) throws SchedulingConflictException {
        Boolean exists = schedulingRepository.existsByRoomIdAndDateAndTimeConflict(dto.getRoomId(),
            dto.getDate(),
            dto.getStartTime(),
            dto.getEndTime()
        );
        if (Boolean.TRUE.equals(exists)){
            throw new SchedulingConflictException("There is already a scheduling at that time for this room.");
        }
    }

    public void validateStartAndEndTimes(LocalTime startTime, LocalTime endTime) {
        if (startTime.isAfter(endTime) || startTime.equals(endTime))
            throw new IllegalArgumentException("Start time cannot be after or the same as end time.");
    }

    public void validateIfRoomExists(Long roomId) {
        if (roomRepository.findById(roomId).isEmpty())
            throw new IllegalArgumentException("Room with ID " + roomId + " does not exist.");
    }
}
