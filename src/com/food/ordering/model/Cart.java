package com.food.ordering.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Cart {
    Map<FoodItem, Integer> quatityDetailsMap;
    String restaurantId;
}
