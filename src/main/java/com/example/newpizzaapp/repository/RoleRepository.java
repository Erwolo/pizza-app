package com.example.newpizzaapp.repository;

import com.example.newpizzaapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByRoleName(String roleName);
}
