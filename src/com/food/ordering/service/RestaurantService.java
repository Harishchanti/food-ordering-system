package com.food.ordering.service;

import com.food.ordering.exceptions.NoRestaurentAvailableException;
import com.food.ordering.model.FoodItem;
import com.food.ordering.model.Restaurant;
import com.food.ordering.model.SearchResults;
import com.food.ordering.repository.RestaurantRepository;


import java.util.*;

public class RestaurantService {

    private OrderService orderService = new OrderServiceImpl();

    public Restaurant createRestaurant(String emailId, String name, String phoneNumber, String address) {
        Restaurant restaurant = new Restaurant(emailId, name, phoneNumber, address);
        RestaurantRepository.restaurantMap.put(emailId, restaurant);
        return restaurant;
    }

    public void menuUpdate(String restaurantEmail, Set<FoodItem> foodItems) throws NoRestaurentAvailableException {
        if (!RestaurantRepository.restaurantMap.containsKey(restaurantEmail))
            throw new NoRestaurentAvailableException("Given restaurant not found in the system");

        Restaurant restaurant = RestaurantRepository.restaurantMap.get(restaurantEmail);
        restaurant.getMenuDetails().getItems().addAll(foodItems);

        RestaurantRepository.restaurantFoodItemsMap.putIfAbsent(restaurantEmail, restaurant.getMenuDetails().getItems());
    }


    public List<SearchResults> getRestaurentsBasedOnCartAvailabilit(List<String> cartDetails) {
        List<SearchResults> searchResults = new ArrayList<>();

        for (Map.Entry<String, Restaurant> entry : RestaurantRepository.restaurantMap.entrySet()) {
            boolean allAvailable = true;
            Double cartValue = 0d;
            Set<FoodItem> foodItems = entry.getValue().getMenuDetails().getItems();
            for (String itemName : cartDetails) {
                Optional<FoodItem> opFood = foodItems.stream().filter(o -> o.getName().equals(itemName)).findFirst();
                if (!opFood.isPresent()) {
                    allAvailable = false;
                    break;
                }
                cartValue += opFood.get().getPrice();
            }

            if (allAvailable) {
                searchResults.add(SearchResults.builder().restaurantName(entry.getKey())
                        .restaurantEmailId(entry.getValue().getEmailId())
                        .totalCartValue(cartValue).build());
            }
        }

        return searchResults;
    }

    private Map<String, Double> getItemsToPriceMap(Set<FoodItem> entry) {
        Map<String, Double> map = new HashMap<>();
        entry.forEach(o -> {
            map.put(o.getName(), o.getPrice());
        });
        return map;
    }
}
