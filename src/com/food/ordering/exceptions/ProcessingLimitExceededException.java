package com.food.ordering.exceptions;

public class ProcessingLimitExceededException extends Exception {

    public ProcessingLimitExceededException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return this.getMessage();
    }
}
