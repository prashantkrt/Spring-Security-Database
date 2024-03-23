package com.microservice.springsecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class TestController {

    @GetMapping("/hello")
    public String greet(HttpServletRequest request) {
        System.out.println("Hello World"+request.getSession()  );
        return "Hello World "+request.getSession();
    }

    @GetMapping("/about")
    public String about(HttpServletRequest request) {
        log.info("logged in with the session is {}",request.getSession());
        return "Prashant "+ request.getSession();
    }
}
