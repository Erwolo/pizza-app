package com.example.newpizzaapp;

import com.example.newpizzaapp.repository.FoodCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final FoodCategoryRepository foodCategoryRepository;

    @Autowired
    public DataLoader(FoodCategoryRepository foodCategoryRepository) {
        this.foodCategoryRepository = foodCategoryRepository;
    }


    public void run(ApplicationArguments args) {

    }
}
