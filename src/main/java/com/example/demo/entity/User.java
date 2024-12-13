package com.example.demo.entity;

import com.example.demo.enumeration.BooleanEnum;
import com.example.demo.enumeration.BooleanEnumConverter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import java.util.Date;

@ApiModel(description = "員工", value = "User")
@Entity
@Table(name = "`user`", indexes = {
    @Index(name = "idx_employee_id", columnList = "employee_id")
})
@NamedEntityGraph(name = "User.role",
    attributeNodes = {
        @NamedAttributeNode(value = "role", subgraph = "Role.noUsers"),
    },
    subgraphs = {
        @NamedSubgraph(name = "Role.noUsers", attributeNodes = {
            @NamedAttributeNode("id"),
            @NamedAttributeNode("name"),
            @NamedAttributeNode("permission")
        })
    }
)
public class User extends BaseEntity {
    
    @Column(name = "employee_id", unique = true, nullable = false, columnDefinition = "varchar(255)")
    private String employeeId;

    @Column(name = "name", nullable = true, columnDefinition = "nvarchar(255)")
    private String name;

    @Column(name = "email", nullable = true, columnDefinition = "nvarchar(255)")
    private String email;

    @Column(name = "enable_status", nullable = false, columnDefinition = "varchar(255)")
    private String enableStatus;
    @Column(name = "memo", nullable = true, columnDefinition = "ntext")
    private String memo;

    @Column(name = "last_logged_in", nullable = true, columnDefinition = "datetime2")
    private Date lastLoggedIn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(String enableStatus) {
        this.enableStatus = enableStatus;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getLastLoggedIn() {
        return lastLoggedIn;
    }

    public void setLastLoggedIn(Date lastLoggedIn) {
        this.lastLoggedIn = lastLoggedIn;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}