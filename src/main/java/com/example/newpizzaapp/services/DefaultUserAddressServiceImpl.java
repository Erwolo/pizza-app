package com.example.newpizzaapp.services;

import com.example.newpizzaapp.model.UserAddress;
import com.example.newpizzaapp.repository.UserAddressRepsitory;
import org.springframework.stereotype.Service;

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
}
