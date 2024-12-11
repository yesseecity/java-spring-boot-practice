package com.example.demo.dto;

public class User extends IdAndCreatedAt {
    private UserModel userModel;
    private RoleModel roleModel;

    // Getters and Setters
    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public RoleModel getRoleModel() {
        return roleModel;
    }

    public void setRoleModel(RoleModel roleModel) {
        this.roleModel = roleModel;
    }
}