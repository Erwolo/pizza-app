package com.example.newpizzaapp.services;

import com.example.newpizzaapp.model.FoodOrderDetail;

public interface FoodOrderDetailService {

    void saveCartPosition(FoodOrderDetail foodOrderDetail);
    FoodOrderDetail saveCartPositionGetObj(FoodOrderDetail foodOrderDetail);

}
