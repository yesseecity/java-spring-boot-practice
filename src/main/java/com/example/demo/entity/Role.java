package com.example.demo.entity;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "role", indexes = {
    @Index(name = "idx_role_name", columnList = "name")
})
public class Role extends BaseEntity {

    /**
     * 角色名稱
     */
    @Column(name = "name", nullable = false, unique = true, columnDefinition = "nvarchar(255) comment '角色名稱'")
    private String name;

    /**
     * 角色權限
     */
    @Column(name = "permission", nullable = false, columnDefinition = "nvarchar(MAX) comment '角色權限'")
    private String permission;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> users;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
}