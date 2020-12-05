package com.example.newpizzaapp.services;

import com.example.newpizzaapp.model.User;
import com.example.newpizzaapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("defaultUserSerivice")
public class DefaultUserServiceImpl implements UserService {
    UserRepository userRepository;

    @Autowired
    public DefaultUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(String fName, String lName) {
        userRepository.save(new User(fName, lName));
    }

}

// Czy to okej podejscie?
