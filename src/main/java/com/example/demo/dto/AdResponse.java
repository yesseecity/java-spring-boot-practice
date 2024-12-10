package com.example.demo.dto;

public class AdResponse {

    private String name;
    private String mail;

    // Constructors
    public AdResponse() {
    }

    public AdResponse(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}