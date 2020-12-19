package com.example.newpizzaapp.services;

import com.example.newpizzaapp.model.Food;
import com.example.newpizzaapp.repository.FoodCategoryRepository;
import com.example.newpizzaapp.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultFoodServiceImpl implements FoodService {

    private final FoodRepository foodRepository;

    @Autowired
    public DefaultFoodServiceImpl(FoodRepository foodRepository, FoodCategoryRepository foodCategoryRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public void addFood(Food food) {
        foodRepository.save(food);
    }

    @Override
    public List<Food> getAllFood() {
        return foodRepository.findAll();
    }

    @Override
    public List<Food> getAllFromCategory(String categoryName) {
        return foodRepository.findAllByFoodCategoryCategoryName(categoryName);
    }
}
