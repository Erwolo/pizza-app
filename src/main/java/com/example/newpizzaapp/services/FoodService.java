package com.example.newpizzaapp.services;

import com.example.newpizzaapp.model.Food;

import java.util.List;

public interface FoodService {
    void addFood(Food food);
    List<Food> getAllFood();
    List<Food> getAllFromCategory(String categoryName);
    Food getFoodById(Long id);

}
