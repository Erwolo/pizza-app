package com.example.newpizzaapp.services;


import com.example.newpizzaapp.model.User;

import java.util.List;

public interface UserService {

    User getUserById(Long id);
    List<User> getAllUsers();
    void saveUser(User user);

}
