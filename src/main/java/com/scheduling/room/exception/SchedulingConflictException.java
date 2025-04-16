package com.scheduling.room.exception;

import javax.management.InstanceAlreadyExistsException;

public class SchedulingConflictException extends InstanceAlreadyExistsException {
    public SchedulingConflictException(String message) {
        super(message);
    }
}
