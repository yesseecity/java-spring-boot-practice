package com.example.demo.dto;

public class GetUserInfoSuccessResponseModel extends SuccessResponseModel {
    private User user;

    // Getters and Setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}