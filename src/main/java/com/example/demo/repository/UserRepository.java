package com.example.demo.repository;

import com.example.demo.entity.User;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(value = "User.role", type = EntityGraph.EntityGraphType.FETCH)
    Optional<User> findById(Long userId);

    @Query("SELECT u FROM User u WHERE u.employeeId = :employeeId")
    Optional<User> findByEmployeeId(@Param("employeeId") String employeeId);

    @Query("SELECT u FROM User u WHERE u.employeeId IN :employeeIds")
    List<User> findByEmployeeIds(@Param("employeeIds") List<String> employeeIds);

    @Query("SELECT u FROM User u JOIN FETCH u.role WHERE u.id = :userId")
    Optional<User> findByIdWithRole(@Param("userId") Integer userId);

    @Query("SELECT u FROM User u JOIN FETCH u.role WHERE u.role.permission LIKE %:permission%")
    List<User> findByPermission(@Param("permission") String permission);

    @Query("SELECT u FROM User u JOIN FETCH u.role WHERE u.name LIKE %:keyword% OR u.employeeId LIKE %:keyword%")
    List<User> findAllWithRoleByKeyword(@Param("keyword") String keyword);

    @Query("SELECT u FROM User u JOIN FETCH u.role ORDER BY u.id DESC")
    List<User> findAllWithRoleOrderedByIdDesc();

    @Query("UPDATE User u SET u.lastLoggedIn = :time WHERE u = :user")
    void updateLastLoggedIn(@Param("user") User user, @Param("time") Date time);

    @Query("DELETE FROM User u WHERE u = :user")
    void deleteUser(@Param("user") User user);
}