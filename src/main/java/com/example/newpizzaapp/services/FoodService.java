package com.example.newpizzaapp.services;

import com.example.newpizzaapp.model.Food;

public interface FoodService {
    void addPizza(Food food);
    void addMainCourse(Food food);
    void addSnack(Food food);
}
