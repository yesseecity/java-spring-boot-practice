package com.example.demo.dto;

public class LoginSuccessResponseModel extends SuccessResponseModel {

    /**
     * jwt token
     */
    private String jwt;

    public LoginSuccessResponseModel(String jwt) {
        this.jwt = jwt;
    }

}