package com.example.demo.dto;

import java.util.Date;

public class UserModel {
    private Integer id;
    private String employeeId;
    private String name;
    private String email;
    private String enableStatus;
    private String memo;
    private Date lastLoggedIn;
    private RoleModel role;

    // public UserModel(Integer id, String employeeId, String name, String email, BooleanEnum enableStatus, String memo, Date lastLoggedIn) {
    //     this.id = id.IntegerValue();
    //     this.employeeId = employeeId;
    //     this.name = name;
    //     this.email = email;
    //     this.enableStatus = enableStatus;
    //     this.memo = memo;
    //     this.lastLoggedIn = lastLoggedIn;
    // }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(String enableStatus) {
        this.enableStatus = enableStatus;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getLastLoggedIn() {
        return lastLoggedIn;
    }

    public void setLastLoggedIn(Date lastLoggedIn) {
        this.lastLoggedIn = lastLoggedIn;
    }

    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }

}