package com.example.newpizzaapp.services;


import com.example.newpizzaapp.model.User;

import java.util.List;

public interface UserService {

    User getUserById(Long id);
    User getUserByLogin(String login);
    List<User> getAllUsers();
    User saveUser(User user);
    void addRoleUser(User user);
    void addRoleAdmin(User user);

}
