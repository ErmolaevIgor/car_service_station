package ru.levelp.car_service_station.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.levelp.car_service_station.model.Users;
import ru.levelp.car_service_station.repository.UserRepo;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Users> userOp = userRepo.findUserByEmail(email);
        if (userOp.isEmpty()) {
            throw new UsernameNotFoundException("No user found with username: " + email);
        }
        Users users = userOp.get();
        return new User(users.getEmail(), users.getPassword(), Collections.emptyList());

    }

}
