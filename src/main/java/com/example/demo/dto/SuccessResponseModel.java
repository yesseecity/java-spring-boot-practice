package com.example.demo.dto;

public class SuccessResponseModel {
    private boolean success;

    public SuccessResponseModel() {
        this.success = true;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}