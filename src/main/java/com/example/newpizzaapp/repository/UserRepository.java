package com.example.newpizzaapp.repository;

import com.example.newpizzaapp.model.Role;
import com.example.newpizzaapp.model.User;
import com.example.newpizzaapp.model.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    User getById(Long id);
    Optional<User> findByLogin(String name);
    User save(User user);

}
