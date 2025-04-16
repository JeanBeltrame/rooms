package com.scheduling.schedule.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public class SchedulingDTO {

    private Long id;

    @NotNull(message = "RoomName must not be null or empty")
    private Long roomId;

    @NotNull(message = "Date must not be null or empty")
    private LocalDate date;

    @NotNull(message = "StartTime must not be null or empty")
    private LocalTime startTime;

    @NotNull(message = "EndTime must not be null or empty")
    private LocalTime endTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
