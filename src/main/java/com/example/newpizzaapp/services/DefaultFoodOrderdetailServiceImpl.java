package com.example.newpizzaapp.services;

import com.example.newpizzaapp.model.FoodOrderDetail;
import com.example.newpizzaapp.repository.FoodOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultFoodOrderdetailServiceImpl implements FoodOrderDetailService {

    private final FoodOrderDetailRepository foodOrderDetailRepository;

    public DefaultFoodOrderdetailServiceImpl(FoodOrderDetailRepository foodOrderDetailRepository) {

        this.foodOrderDetailRepository = foodOrderDetailRepository;
    }

    @Override
    public void saveCartPosition(FoodOrderDetail foodOrderDetail) {
        foodOrderDetailRepository.save(foodOrderDetail);
    }

    @Override
    public FoodOrderDetail saveCartPositionGetObj(FoodOrderDetail foodOrderDetail) {
        FoodOrderDetail returnedObj = foodOrderDetailRepository.save(foodOrderDetail);
        return returnedObj;
    }


}
