package com.microservice.springsecurity.service;

import com.microservice.springsecurity.dao.UsersDao;
import com.microservice.springsecurity.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);//2^12 rounds

    @Autowired
    private UsersDao repo;

    public Users registerUser(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }
}
