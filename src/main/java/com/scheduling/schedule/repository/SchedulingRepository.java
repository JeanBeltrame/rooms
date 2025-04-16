package com.scheduling.schedule.repository;

import com.scheduling.model.Scheduling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

public interface SchedulingRepository extends JpaRepository<Scheduling, Long>, JpaSpecificationExecutor<Scheduling> {

    @Query("""
    SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END
    FROM Scheduling s
    WHERE s.room.id = :roomId
      AND s.date = :date
      AND (
            (s.startTime < :endTime AND s.endTime > :startTime)
          )
    """)
    Boolean existsByRoomIdAndDateAndTimeConflict(
            @Param("roomId") Long roomId,
            @Param("date") LocalDate date,
            @Param("startTime") LocalTime startTime,
            @Param("endTime") LocalTime endTime
    );

}
