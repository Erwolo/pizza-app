package com.example.newpizzaapp.services;

import com.example.newpizzaapp.model.UserAddress;

import java.util.List;

public interface UserAddressService {

    UserAddress saveAddressGetObj(UserAddress userAddress);
    List<UserAddress> getUserAdresses(String login);
    UserAddress findById(Long id);

}
