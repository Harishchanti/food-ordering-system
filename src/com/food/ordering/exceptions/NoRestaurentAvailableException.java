package com.food.ordering.exceptions;

public class NoRestaurentAvailableException extends Exception {
    public NoRestaurentAvailableException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
