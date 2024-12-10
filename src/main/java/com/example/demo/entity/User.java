package com.example.demo.entity;

import com.example.demo.enumeration.BooleanEnum;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user", indexes = {
    @Index(name = "idx_employee_id", columnList = "employee_id")
})
public class User extends BaseEntity {

    @Column(name = "employee_id", unique = true, nullable = false, columnDefinition = "varchar(255) comment '員編'")
    private String employeeId;

    @Column(name = "name", nullable = true, columnDefinition = "nvarchar(255) comment '姓名'")
    private String name;

    @Column(name = "email", nullable = true, columnDefinition = "nvarchar(255) comment '信箱'")
    private String email;

    @Column(name = "enable_status", nullable = false, columnDefinition = "varchar(255) comment '啟用狀態'")
    private BooleanEnum enableStatus;

    @Column(name = "memo", nullable = true, columnDefinition = "ntext comment '備註'")
    private String memo;

    @Column(name = "last_logged_in", nullable = true, columnDefinition = "datetime2 comment '上次登入時間'")
    private Date lastLoggedIn;

    @ManyToOne
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

    public BooleanEnum getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(BooleanEnum enableStatus) {
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