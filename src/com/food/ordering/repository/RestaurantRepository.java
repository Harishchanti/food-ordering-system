package com.food.ordering.repository;

import com.food.ordering.model.FoodItem;
import com.food.ordering.model.Restaurant;
import com.food.ordering.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
public class RestaurantRepository {
    public static Map<String, Restaurant> restaurantMap = new HashMap<>();
    public static Map<String, Set<FoodItem>> restaurantFoodItemsMap = new HashMap<>();

}
