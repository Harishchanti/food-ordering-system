package com.food.ordering.repository;

import com.food.ordering.model.FoodItem;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class FoodItemsRepository {
    public static Set<FoodItem> foodItems = new HashSet<>();
}
