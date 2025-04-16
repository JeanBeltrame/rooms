package com.scheduling.schedule.repository;

import com.scheduling.model.Scheduling;
import com.scheduling.room.constants.RoomConstants;
import com.scheduling.schedule.constants.SchedulingConstants;
import org.springframework.data.jpa.domain.Specification;

public class SchedulingSpecification {

    public static Specification<Scheduling> equalRoomId(Long roomId) {
        return (root, query, cb) -> {
            return cb.equal(root.get(SchedulingConstants.ROOM).get(RoomConstants.ID), roomId);
        };
    }

}
