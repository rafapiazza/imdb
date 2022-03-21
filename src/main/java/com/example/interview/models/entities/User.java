package com.example.interview.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user")
//@Where(clause = "is_Active")
public class User {

    @Id
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "isAdmin", nullable = false)
    private Boolean isAdmin;

    @Column(name = "token")
    private Long token;

    @Column(name = "isActive")
    private Boolean isActive;

}
