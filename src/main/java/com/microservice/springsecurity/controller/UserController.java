package com.microservice.springsecurity.controller;

import com.microservice.springsecurity.model.Users;
import com.microservice.springsecurity.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UsersService service;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Users user) {
        service.registerUser(user);
        return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
    }
}