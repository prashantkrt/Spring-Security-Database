package com.microservice.springsecurity.dao;

import com.microservice.springsecurity.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDao extends JpaRepository<Users,String> {
}
