package com.food.ordering.repository;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import com.food.ordering.model.User;

@Getter
@Setter
public class UserRepository {
    public static Map<String, User> userHashMap = new HashMap<>();
}
