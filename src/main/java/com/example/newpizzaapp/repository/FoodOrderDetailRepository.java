package com.example.newpizzaapp.repository;

import com.example.newpizzaapp.model.FoodOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodOrderDetailRepository extends JpaRepository<FoodOrderDetail, Long> {
    FoodOrderDetail save(FoodOrderDetail foodOrderDetail);
}
