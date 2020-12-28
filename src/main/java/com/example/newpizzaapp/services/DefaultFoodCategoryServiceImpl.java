package com.example.newpizzaapp.services;

import com.example.newpizzaapp.model.FoodCategory;
import com.example.newpizzaapp.repository.FoodCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class DefaultFoodCategoryServiceImpl implements FoodCategoryService {

    private final FoodCategoryRepository foodCategoryRepository;

    public DefaultFoodCategoryServiceImpl(FoodCategoryRepository foodCategoryRepository) {
        this.foodCategoryRepository = foodCategoryRepository;
    }

    @Override
    public List<FoodCategory> getAllCategories() {
        return foodCategoryRepository.findAll();
    }
}
