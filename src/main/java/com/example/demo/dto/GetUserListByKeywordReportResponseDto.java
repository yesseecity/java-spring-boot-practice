package com.example.demo.dto;

import com.example.demo.entity.User;
import java.util.List;

public class GetUserListByKeywordReportResponseDto {

    private List<User> data;
    private String base64File;

    // Getters and Setters
    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    public String getBase64File() {
        return base64File;
    }

    public void setBase64File(String base64File) {
        this.base64File = base64File;
    }
}