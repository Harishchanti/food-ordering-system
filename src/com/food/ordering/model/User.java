package com.food.ordering.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    String id;
    String name;
    String emailId;
    String phoneNumber;

    public User(String emailId, String name, String phoneNumber) {
        id = UUID.randomUUID().toString();
        this.emailId = emailId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}