package com.scheduling.config.exception;

import com.scheduling.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.management.InstanceAlreadyExistsException;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(InstanceAlreadyExistsException.class)
    public ResponseEntity<ApiErrorMessage> handleAlreadyExists(InstanceAlreadyExistsException ex) {
        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(HttpStatus.CONFLICT,
                HttpStatus.CONFLICT.value(), ex.getMessage());

        return new ResponseEntity<>(apiErrorMessage, apiErrorMessage.getStatus());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiErrorMessage> handleNotFoundException(NotFoundException ex) {
        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(HttpStatus.NOT_FOUND,
                HttpStatus.NOT_FOUND.value(), ex.getMessage());

        return new ResponseEntity<ApiErrorMessage>(apiErrorMessage, apiErrorMessage.getStatus());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiErrorMessage> handleIllegalArgumentException(Exception ex) {
        ApiErrorMessage apiErrorMessage = new ApiErrorMessage(HttpStatus.UNPROCESSABLE_ENTITY,
                HttpStatus.UNPROCESSABLE_ENTITY.value(), ex.getMessage());

        return new ResponseEntity<ApiErrorMessage>(apiErrorMessage, apiErrorMessage.getStatus());
    }

}
