package com.example.demo.exception;

public class ExpectedErrorResponseModel extends RuntimeException {

    private String errorCode;
    private String errorMessage;

    public ExpectedErrorResponseModel(String errorCode) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMessage = getDefaultErrorMessage(errorCode);
    }

    public ExpectedErrorResponseModel(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    private String getDefaultErrorMessage(String errorCode) {
        // 根據錯誤代碼返回默認的錯誤消息
        switch (errorCode) {
            case "B085":
                return "User not found";
            case "D060":
                return "Role not found";
            case "D001":
                return "Data not found";
            case "B018":
                return "User already exists";
            case "W008":
                return "Invalid action";
            default:
                return "Unknown error";
        }
    }
}