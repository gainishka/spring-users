package com.example.users.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String userName;

    private float userSalary;

    public User() {
    }

    public User(Long userId, String userName, float userSalary) {
        this.userId = userId;
        this.userName = userName;
        this.userSalary = userSalary;
    }

    public User( String userName, float userSalary) {
        this.userName = userName;
        this.userSalary = userSalary;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public float getUserSalary() {
        return userSalary;
    }

    public void setUserSalary(float userSalary) {
        this.userSalary = userSalary;
    }
}
