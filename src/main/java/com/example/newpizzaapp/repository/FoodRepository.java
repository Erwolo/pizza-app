package com.example.newpizzaapp.repository;

import com.example.newpizzaapp.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
