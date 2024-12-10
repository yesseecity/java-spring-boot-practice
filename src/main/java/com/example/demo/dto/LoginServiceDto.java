package com.example.demo.dto;

import javax.validation.constraints.NotBlank;

public class LoginServiceDto {

    @NotBlank(message = "Employee ID is mandatory")
    private String employeeId;

    @NotBlank(message = "Password is mandatory")
    private String password;

    // Getters and Setters
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}