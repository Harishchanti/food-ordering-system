package com.food.ordering.model;

import lombok.*;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class SearchResults {
    String restaurantEmailId;
    String restaurantName;
    Double totalCartValue;
}
