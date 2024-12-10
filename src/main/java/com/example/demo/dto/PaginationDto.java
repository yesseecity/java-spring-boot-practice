package com.example.demo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PaginationDto {

    @NotNull(message = "Page number is mandatory")
    @Min(value = 1, message = "Page number should be at least 1")
    private Integer page;

    @NotNull(message = "Limit is mandatory")
    @Min(value = 1, message = "Limit should be at least 1")
    private Integer limit;

    private Boolean allData;

    // Getters and Setters
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Boolean getAllData() {
        return allData;
    }

    public void setAllData(Boolean allData) {
        this.allData = allData;
    }
}