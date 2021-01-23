package com.example.newpizzaapp.repository;

import com.example.newpizzaapp.model.Food;
import com.example.newpizzaapp.model.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findAllByFoodCategoryCategoryName(String categoryName);

    @Transactional
    @Modifying
    @Query("update Food u set u.foodName = :name where u.id = :id")
    void updateFoodNameById(@Param(value = "id") long id, @Param(value = "name") String name);

    @Transactional
    @Query("update Food u set u.price = :price where u.id = :id")
    void updateFoodPriceById(@Param(value = "id") long id, @Param(value = "price") Float price);

    /*@Query("update Food u set u.foodCategory = :price where u.id = :id")
    void updateFoodCategoryById(@Param(value = "id") long id, @Param(value = "category") FoodCategory foodCategory);*/


}
