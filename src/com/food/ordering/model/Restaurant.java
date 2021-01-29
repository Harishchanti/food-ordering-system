package com.food.ordering.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Restaurant {
    String id;
    String name;
    String emailId;
    String phoneNumber;
    String address;
    LocalDateTime registerdDate;
    MenuDetails menuDetails = new MenuDetails();

    public Restaurant( String emailId, String name, String phoneNumber, String address) {
        id = UUID.randomUUID().toString();
        this.emailId = emailId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.registerdDate = LocalDateTime.now();
    }
}