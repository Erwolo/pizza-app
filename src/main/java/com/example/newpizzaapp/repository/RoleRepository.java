package com.example.newpizzaapp.repository;

import com.example.newpizzaapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByRoleName(String roleName);

//    @Query("SELECT role.role_name FROM role, user, users_roles WHERE user.id = users_roles.user_id and user.id = ?1 and role.id = users_roles.role_id")
    List<Role> findAllByUsersId(Long id);
}
