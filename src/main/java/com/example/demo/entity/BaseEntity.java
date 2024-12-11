package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(updatable = false)
    private Date createdAt;

    private Date updatedAt;

    @Column(nullable = true)
    private Date deletedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        updatedAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }

    // Getters and Setters
    public Long getId() {
        return id.longValue();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
    
    public Map<String, Object> toResponseData() {
        Map<String, Object> responseData = new HashMap<>();
        for (java.lang.reflect.Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                if (!field.getName().equals("updatedAt") && !field.getName().equals("deletedAt")) {
                    responseData.put(field.getName(), field.get(this));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return responseData;
    }

    public static <T extends BaseEntity> PaginateResponse<T> paginate(List<T> data, int total, int page, int limit) {
        PageInfo pageInfo = new PageInfo(total, page, limit);
        return new PaginateResponse<>(data, pageInfo);
    }

    public static class PageInfo {
        private int total;
        private Integer page;
        private int limit;

        public PageInfo(int total, Integer page, int limit) {
            this.total = total;
            this.page = page;
            this.limit = limit;
        }

        // Getters and Setters
        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }
    }

    public static class PaginateResponse<T> {
        private List<T> data;
        private PageInfo pageInfo;

        public PaginateResponse(List<T> data, PageInfo pageInfo) {
            this.data = data;
            this.pageInfo = pageInfo;
        }

        // Getters and Setters
        public List<T> getData() {
            return data;
        }

        public void setData(List<T> data) {
            this.data = data;
        }

        public PageInfo getPageInfo() {
            return pageInfo;
        }

        public void setPageInfo(PageInfo pageInfo) {
            this.pageInfo = pageInfo;
        }
    }
}