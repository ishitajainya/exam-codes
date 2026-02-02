package com.traineeMgt.globalExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.traineeMgt.exception.ErrorResponse;
import com.traineeMgt.exception.TraineeDataAccessException;
import com.traineeMgt.exception.TraineeNotFoundException;
@RestControllerAdvice
public class GlobalExceptionHandler {

    // handles persistence exceptions
    @ExceptionHandler(TraineeDataAccessException.class)
    public ResponseEntity<ErrorResponse> handleDataAccessException(
            TraineeDataAccessException ex) {

        ErrorResponse error = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage()
        );

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // handles trainee not found
    @ExceptionHandler(TraineeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(
            TraineeNotFoundException ex) {

        ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // handles any other unexpected exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {

        ErrorResponse error = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Unexpected error occurred"
        );

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
