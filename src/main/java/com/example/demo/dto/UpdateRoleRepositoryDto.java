package com.example.demo.dto;

import com.example.demo.entity.Role;

import javax.validation.constraints.NotNull;
import java.util.List;

public class UpdateRoleRepositoryDto {

    @NotNull(message = "Role is mandatory")
    private Role role;

    private UpdateRoleData updateRoleData;

    // Getters and Setters
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UpdateRoleData getUpdateRoleData() {
        return updateRoleData;
    }

    public void setUpdateRoleData(UpdateRoleData updateRoleData) {
        this.updateRoleData = updateRoleData;
    }

    public static class UpdateRoleData {
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
}