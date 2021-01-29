package com.food.ordering.service;

import com.food.ordering.model.Cart;

import java.util.List;

public interface OrderService {
    String placeOrder(Cart cart);
}
