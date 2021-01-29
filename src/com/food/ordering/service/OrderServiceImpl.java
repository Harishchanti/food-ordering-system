package com.food.ordering.service;

import com.food.ordering.model.Cart;

public class OrderServiceImpl implements OrderService {

    @Override
    public String placeOrder(Cart cart) {
        System.out.println("Order placed succesfuly");
        return "Success";
    }
}
