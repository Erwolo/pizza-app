package com.example.newpizzaapp;

import com.example.newpizzaapp.repository.FoodCategoryRepository;
import com.example.newpizzaapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final FoodCategoryRepository foodCategoryRepository;
    private final OrderRepository orderRepository;

    public DataLoader(FoodCategoryRepository foodCategoryRepository, OrderRepository orderRepository) {
        this.foodCategoryRepository = foodCategoryRepository;
        this.orderRepository = orderRepository;
    }


    public void run(ApplicationArguments args) {

    }
}
