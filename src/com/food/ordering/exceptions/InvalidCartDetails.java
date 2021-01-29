package com.food.ordering.exceptions;

public class InvalidCartDetails extends Exception {

    public InvalidCartDetails(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
