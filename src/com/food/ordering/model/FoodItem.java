package com.food.ordering.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class FoodItem {

    String name;
    double price;// excluding taxes
    FoodItemType foodItemType;
    FoodCatagoey foodCatagoey;
}
