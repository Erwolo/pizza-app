package com.example.newpizzaapp.services;

import com.example.newpizzaapp.model.Food;
import com.example.newpizzaapp.model.FoodCategory;

import java.util.List;

public interface FoodService {
    void addFood(Food food);
    List<Food> getAllFood();
    List<Food> getAllFromCategory(String categoryName);
    Food getFoodById(Long id);
    void updateFoodName(long id, String name);
    void updateFoodPrice(long id, Float price);
    void removeFoodById(Long id);

}
