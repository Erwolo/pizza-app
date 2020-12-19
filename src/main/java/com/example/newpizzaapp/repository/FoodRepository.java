package com.example.newpizzaapp.repository;

import com.example.newpizzaapp.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findAllByFoodCategoryCategoryName(String categoryName);
}
