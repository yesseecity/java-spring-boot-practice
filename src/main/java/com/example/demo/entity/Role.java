package com.example.demo.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "role", indexes = {
    @Index(name = "idx_role_name", columnList = "name")
})
@NamedEntityGraph(name = "Role", attributeNodes = {
    @NamedAttributeNode("id"),
    @NamedAttributeNode("name"),
    @NamedAttributeNode("permission")
})
public class Role extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true, columnDefinition = "nvarchar(255)")
    private String name;

    @Column(name = "permission", nullable = false, columnDefinition = "nvarchar(max)")
    private String permission;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
    private List<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPermission() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> list;
        try {
            list = objectMapper.readValue(permission, new TypeReference<List<String>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to parse permissions", e);
        }
        return list;
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

    @Override
    public String toString() {
        return "\nRole{" + "\n"+
                "  id:" + getId() + ",\n"+
                "  name:'" + name + '\'' + ",\n"+
                "  permission:" + permission + ",\n"+
                "  users:" + users.toString() + "\n"+
                '}';
    }
}