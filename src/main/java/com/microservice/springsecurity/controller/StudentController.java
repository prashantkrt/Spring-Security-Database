package com.microservice.springsecurity.controller;

import com.microservice.springsecurity.entity.Student;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//cross-site request forgery(CSRF)
@RestController
@Log4j2
public class StudentController {

    List<Student> list1 = new ArrayList<>(List.of(new Student(1, "Akash", "Java")
            , new Student(2, "Vinod", "CPP")
            , new Student(3, "Rajesh", "GoLang")));

    List<Student> list2 = new ArrayList<>(Arrays.asList(new Student(4, "Amit", "Java")
            , new Student(5, "Mohan", "CPP")
            , new Student(6, "Bunny", "GoLang")));

    @GetMapping("/students")
    public List<Student> getStudent() {
        list1.addAll(list2);
        return list1;
    }

    @GetMapping("csrf-token")
    public CsrfToken getCSRFToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public void addStudent(@RequestBody Student student) {
        log.info("In addStudent controller");
        list1.add(student);
    }
}
