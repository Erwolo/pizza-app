package com.example.newpizzaapp.repository;

import com.example.newpizzaapp.model.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserAddressRepsitory extends JpaRepository<UserAddress, Long> {

    UserAddress save(UserAddress userAddress);
    List<UserAddress> getAllByUserLogin(String login);
    UserAddress findUserAddressById(Long id);


}
