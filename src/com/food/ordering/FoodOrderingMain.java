package com.food.ordering;

import com.food.ordering.exceptions.NoRestaurentAvailableException;
import com.food.ordering.model.*;
import com.food.ordering.service.CartValueComparator;
import com.food.ordering.service.RestaurantService;

import java.util.*;

public class FoodOrderingMain {
    static RestaurantService restaurantService = new RestaurantService();

    public static void main(String[] args) throws NoRestaurentAvailableException {
        createTestRestaurants();
        populateRestaurantMenu();

        //update Restau
        FoodItem foodItem = new FoodItem("Poha", 60, FoodItemType.VEG, FoodCatagoey.TIFFIN);
        updateRestaurantMenu("aaa@gmail.com", foodItem);

        List<String> cartDetails = Arrays.asList("idli", "dosa");
        List<SearchResults> restaurant = getAvailableRestaurant(cartDetails);

        System.out.println("======== List of restaurant carrying ========" + cartDetails);

        restaurant.forEach(o -> System.out.println(o.getRestaurantName() + "   " + o.getTotalCartValue()));


        System.out.println("Done......");
    }

    private static List<SearchResults> getAvailableRestaurant(List<String> cartDetails) {
        List<SearchResults> searchResults = restaurantService.getRestaurentsBasedOnCartAvailabilit(cartDetails);
        Collections.sort(searchResults, new CartValueComparator());
        return searchResults;
    }

    private static void updateRestaurantMenu(String restaurantEmail, FoodItem foodItem) throws NoRestaurentAvailableException {
        Set<FoodItem> foodItems = new HashSet<FoodItem>();
        foodItems.add(foodItem);
        restaurantService.menuUpdate(restaurantEmail, foodItems);
    }

    private static void populateRestaurantMenu() throws NoRestaurentAvailableException {
        Set<FoodItem> foodItemList1 = new HashSet<>();
        foodItemList1.add(new FoodItem("idli", 30, FoodItemType.VEG, FoodCatagoey.TIFFIN));
        foodItemList1.add(new FoodItem("dosa", 40, FoodItemType.VEG, FoodCatagoey.TIFFIN));
        foodItemList1.add(new FoodItem("puri", 50, FoodItemType.VEG, FoodCatagoey.TIFFIN));
        foodItemList1.add(new FoodItem("chiken biriyani", 300, FoodItemType.NON_VEG, FoodCatagoey.TIFFIN));
        restaurantService.menuUpdate("aaa@gmail.com", foodItemList1);

        Set<FoodItem> foodItemList2 = new HashSet<>();
        foodItemList2.add(new FoodItem("idli", 33, FoodItemType.VEG, FoodCatagoey.TIFFIN));
        foodItemList2.add(new FoodItem("vada", 20, FoodItemType.VEG, FoodCatagoey.TIFFIN));
        foodItemList2.add(new FoodItem("chiken biriyani", 255, FoodItemType.NON_VEG, FoodCatagoey.MAIN_COURSE));
        restaurantService.menuUpdate("bbb@gmail.com", foodItemList2);


        Set<FoodItem> foodItemList3 = new HashSet<>();
        foodItemList3.add(new FoodItem("idli", 30, FoodItemType.VEG, FoodCatagoey.STARTERS));
        foodItemList3.add(new FoodItem("dosa", 44, FoodItemType.VEG, FoodCatagoey.STARTERS));
        foodItemList3.add(new FoodItem("mutton biriyani", 350, FoodItemType.NON_VEG, FoodCatagoey.STARTERS));
        restaurantService.menuUpdate("ccc@gmail.com", foodItemList3);


    }

    private static void createTestRestaurants() {
        Restaurant Restaurant1 = restaurantService.createRestaurant("aaa@gmail.com", "Barathi", "923456789", "HSR Layout");
        Restaurant Restaurant2 = restaurantService.createRestaurant("bbb@gmail.com", "Sanju", "993456789", "Kormangala");
        Restaurant Restaurant3 = restaurantService.createRestaurant("ccc@gmail.com", "Harish", "883456789", " BTM ");
        Restaurant Restaurant4 = restaurantService.createRestaurant("ddd@gmail.com", "Adi", "863456789", " Jp Nagar");
        Restaurant Restaurant5 = restaurantService.createRestaurant("eee@gmail.com", "Rajesh", "673456789", "Basvangudi");
    }

}
