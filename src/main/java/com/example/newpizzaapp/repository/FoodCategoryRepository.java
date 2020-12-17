package com.example.newpizzaapp.repository;

import com.example.newpizzaapp.model.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
    FoodCategory findFoodCategoryByCategoryName(String name);

}
