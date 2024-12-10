package com.example.demo.dto;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class CreateRoleRepositoryDto {

    @NotBlank(message = "Role name is mandatory")
    private String name;

    private List<String> permission;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPermission() {
        return permission;
    }

    public void setPermission(List<String> permission) {
        this.permission = permission;
    }
}