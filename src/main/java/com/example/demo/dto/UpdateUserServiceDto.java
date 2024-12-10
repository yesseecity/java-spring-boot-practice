package com.example.demo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class UpdateUserServiceDto {
    @NotNull(message = "User ID is mandatory")
    @Min(value = 1, message = "User ID should be at least 1")
    
    private Long userId;

    private Long roleId;

    private String memo;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getMemo() {
        return memo;
    }
    
    public void setMemo(String memo) {
        this.memo = memo;
    }
    
}
