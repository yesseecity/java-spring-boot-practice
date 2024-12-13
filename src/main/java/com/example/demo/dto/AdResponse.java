package com.example.demo.dto;


public class AdResponse {
    private UserModel user;

    // Constructors
    public AdResponse() {
    }

    public AdResponse(UserModel user) {
        this.user = user;
    }

    // Getters and Setters
    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}