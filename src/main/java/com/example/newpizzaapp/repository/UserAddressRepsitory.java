package com.example.newpizzaapp.repository;

import com.example.newpizzaapp.model.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAddressRepsitory extends JpaRepository<UserAddress, Long> {

    UserAddress save(UserAddress userAddress);

}
