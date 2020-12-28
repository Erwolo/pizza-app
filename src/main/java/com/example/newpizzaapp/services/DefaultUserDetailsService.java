package com.example.newpizzaapp.services;

import com.example.newpizzaapp.model.MyUserDetails;
import com.example.newpizzaapp.model.User;
import com.example.newpizzaapp.repository.RoleRepository;
import com.example.newpizzaapp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("defaultUserDetailsService")
public class DefaultUserDetailsService implements UserDetailsService {
    Logger log = LoggerFactory.getLogger(DefaultUserDetailsService.class);


    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public DefaultUserDetailsService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // w tej metodzie pobierane sa user detail po nazwie uzytkownika
        // a więc trzeba oprogramować JPA tak aby podawalo User Details po username
        // Ta metoda łączy Spring Security z pobieranymi danymi, nie musi to być nawet baza danych
        Optional<User> user = userRepository.findByLogin(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

//        log.info("Role użytkownika: " + roleRepository.findAllByUsersId(user.get().getId()));
        UserDetails ud = user.map(MyUserDetails::new).get();

        // #3
        /*Collection<CustomGrantedAuthority> auths = new ArrayList<>();
        auths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        auths.add(new SimpleGrantedAuthority("ROLE_USER"));
        ud.getAuthorities().addAll(auths);*/

        // #1
        /*List<String> roles = new ArrayList<>();
        List<GrantedAuthority> auths = new ArrayList<>();
        roleRepository.findAllByUsersId(user.get().getId()).forEach(e -> roles.add(e.getRoleName()));
        roles.forEach(e -> auths.add(new SimpleGrantedAuthority("ROLE_" + e)));
        ud.getAuthorities().addAll(auths);*/

        // #2
        //roleRepository.findAllByUsersId(user.get().getId()).forEach(e -> ud.getAuthorities().add(new SimpleGrantedAuthority("ROLE_" + e.getRoleName())));

        return ud;
    }
}
