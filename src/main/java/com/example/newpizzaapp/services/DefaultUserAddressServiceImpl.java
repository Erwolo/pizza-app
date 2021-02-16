package com.example.newpizzaapp.services;

import com.example.newpizzaapp.model.UserAddress;
import com.example.newpizzaapp.repository.UserAddressRepsitory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultUserAddressServiceImpl implements UserAddressService {

    private final UserAddressRepsitory userAddressRepsitory;

    public DefaultUserAddressServiceImpl(UserAddressRepsitory userAddressRepsitory) {
        this.userAddressRepsitory = userAddressRepsitory;
    }

    @Override
    public UserAddress saveAddressGetObj(UserAddress userAddress) {
        UserAddress address = userAddressRepsitory.save(userAddress);
        return address;
    }

    @Override
    public List<UserAddress> getUserAdresses(String login) {
        return userAddressRepsitory.getAllByUserLogin(login);
    }

    @Override
    public UserAddress findById(Long id) {
        return userAddressRepsitory.findUserAddressById(id);
    }
}
