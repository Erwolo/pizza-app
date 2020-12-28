package com.example.newpizzaapp.services;

import com.example.newpizzaapp.model.User;
import com.example.newpizzaapp.repository.RoleRepository;
import com.example.newpizzaapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultUserServiceImpl implements UserService {
    final UserRepository userRepository;
    final RoleRepository roleRepository;

    public DefaultUserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
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
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void addRoleUser(User user) {
        user.getRoles().add(roleRepository.findRoleByRoleName("USER"));
    }

    @Override
    public void addRoleAdmin(User user) {
        user.getRoles().add(roleRepository.findRoleByRoleName("ADMIN"));
    }

}

