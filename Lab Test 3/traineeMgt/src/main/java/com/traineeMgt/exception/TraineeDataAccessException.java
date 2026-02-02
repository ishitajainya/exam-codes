package com.traineeMgt.exception;

public class TraineeDataAccessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TraineeDataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public TraineeDataAccessException(String message) {
        super(message);
    }
}
