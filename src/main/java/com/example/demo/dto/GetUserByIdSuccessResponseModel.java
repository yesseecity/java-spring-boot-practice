package com.example.demo.dto;

import com.example.demo.entity.User;

import java.util.Date;

import com.example.demo.entity.Role;

public class GetUserByIdSuccessResponseModel extends SuccessResponseModel {
    private UserWithRole user;

    public UserWithRole getUser() {
        return user;
    }

    public void setUser(UserWithRole user) {
        this.user = user;
    }

    public static class UserWithRole extends User {
        private RoleWithIdAndCreatedAt role;

        public RoleWithIdAndCreatedAt getRole() {
            return role;
        }

        public void setRole(RoleWithIdAndCreatedAt role) {
            this.role = role;
        }
    }

    public static class RoleWithIdAndCreatedAt extends Role {
        private Long id;
        private Date createdAt;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Date getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }
    }
}