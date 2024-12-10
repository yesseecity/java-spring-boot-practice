package com.example.demo.repository;

import com.example.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("SELECT r FROM Role r WHERE r.name = :roleName AND r.deletedAt IS NOT NULL")
    Optional<Role> findSoftRemovedRoleByName(@Param("roleName") String roleName);

    @Query("SELECT r FROM Role r ORDER BY r.id DESC")
    List<Role> findAllOrderedByIdDesc();

    @Query("SELECT COUNT(u) FROM User u WHERE u.role.id = :roleId")
    long countUsersByRoleId(@Param("roleId") Long roleId);

    @Query("SELECT COUNT(u) FROM User u WHERE u.role.name = 'admin'")
    long countUsersWithAdminRole();

    @Query("SELECT COUNT(r) > 0 FROM Role r WHERE r.name = :roleName")
    boolean existsByName(@Param("roleName") String roleName);
}