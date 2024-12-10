package com.example.demo.dto;

import javax.validation.Valid;

public class GetUserListByKeywordReportServiceDto {

    private String keyword;

    @Valid
    private PaginationDto pageInfo;

    // Getters and Setters
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public PaginationDto getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PaginationDto pageInfo) {
        this.pageInfo = pageInfo;
    }
}