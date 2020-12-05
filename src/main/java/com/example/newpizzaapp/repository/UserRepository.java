package com.example.newpizzaapp.repository;

import com.example.newpizzaapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    User getById(Long id);
    List<User> findAllBy();
}
