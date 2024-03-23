package com.microservice.springsecurity.service;

import com.microservice.springsecurity.dao.UsersDao;
import com.microservice.springsecurity.entity.UserPrincipal;
import com.microservice.springsecurity.model.Users;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class MyUserService implements UserDetailsService {

    @Autowired
    private UsersDao repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user = repo.findById(username);
        if (user.isEmpty()) {
            log.info("user is not present");
            throw new UsernameNotFoundException("User 404");
        }
        return new UserPrincipal(user.get());
    }
}
