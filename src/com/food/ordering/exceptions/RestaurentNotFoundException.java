package com.food.ordering.exceptions;

public class RestaurentNotFoundException extends Exception {
    public RestaurentNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
