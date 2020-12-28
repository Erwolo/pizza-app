package com.example.newpizzaapp.model;

import com.example.newpizzaapp.repository.RoleRepository;
import com.example.newpizzaapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {

    private String userName;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;




    public MyUserDetails() { }

    public MyUserDetails(User user) {
        this.userName = user.getLogin();
        this.password = user.getPassword();
        this.active = user.isActive();
        // Tu se robie Collection<GrantedAuthority>
        this.authorities = new ArrayList<>();
//        roleRepository.findAllByUsersId(user.getId()).forEach(e -> authorities.add(new SimpleGrantedAuthority("ROLE_" + e.getRoleName())));
//        System.out.println(roleRepository.findAllByUsersId(user.getId()));


        user.getRoles().forEach(e -> authorities.add(new SimpleGrantedAuthority("ROLE_" + e.getRoleName())));

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
