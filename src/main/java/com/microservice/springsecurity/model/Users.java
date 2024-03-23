package com.microservice.springsecurity.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class Users {
    @Column(name = "id")
    private Integer id;
    @Id
    @Column(name = "username")
    private String name;
    @Column(name = "password")
    private String password;
}
