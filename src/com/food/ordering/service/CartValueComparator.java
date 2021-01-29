package com.food.ordering.service;

import com.food.ordering.model.SearchResults;

import java.util.Comparator;

public class CartValueComparator implements Comparator<SearchResults> {
    @Override
    public int compare(SearchResults o1, SearchResults o2) {
        return o1.getTotalCartValue() == o2.getTotalCartValue() ? 0 : (o1.getTotalCartValue() > o2.getTotalCartValue()) ? 1 : -1;
    }
}
