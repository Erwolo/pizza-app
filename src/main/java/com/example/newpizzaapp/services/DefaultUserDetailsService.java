package com.example.newpizzaapp.services;

import com.example.newpizzaapp.model.MyUserDetails;
import com.example.newpizzaapp.model.User;
import com.example.newpizzaapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("defaultUserDetailsService")
public class DefaultUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public DefaultUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // w tej metodzie pobierane sa user detail po nazwie uzytkownika
        // a więc trzeba oprogramować JPA tak aby podawalo User Details po username
        // Ta metoda łączy Spring Security z pobieranymi danymi, nie musi to być nawet baza danych
        Optional<User> user = userRepository.findByLogin(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

        return user.map(MyUserDetails::new).get();
    }
}
