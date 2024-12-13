package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.entity.Role;
import com.example.demo.exception.ExpectedErrorResponseModel;
import com.example.demo.repository.RoleRepository;
import com.example.demo.util.LoggerUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private LoggerUtil loggerUtil;

    @Transactional
    public Role createRole(CreateRoleRepositoryDto dto) {
        loggerUtil.debug("createRole service " + dto.getName());

        Optional<Role> softRemovedRoleOpt = roleRepository.findSoftRemovedRoleByName(dto.getName());
        softRemovedRoleOpt.ifPresent(role -> roleRepository.delete(role));

        Role newRole = new Role();
        newRole.setName(dto.getName());
        newRole.setPermission(stringifyPermission(dto.getPermission()));

        return roleRepository.save(newRole);
    }

    public Optional<Role> getRoleById(Long roleId) {
        return roleRepository.findById(roleId);
    }

    public Optional<Role> getRoleByIdWithParsedPermission(Long roleId) {
        Optional<Role> roleOpt = getRoleById(roleId);
        return roleOpt;
    }

    public List<Role> getRoleListWithParsedPermission(PaginationDto dto) {
        List<Role> roles = roleRepository.findAllOrderedByIdDesc();
        return roles;
    }

    @Transactional
    public Role updateRole(UpdateRoleRepositoryDto dto) {
        loggerUtil.debug("updateRole service " + dto.getRole().getId());

        Role role = roleRepository.findById(dto.getRole().getId().longValue())
                .orElseThrow(() -> new ExpectedErrorResponseModel("D060"));

        if (dto.getUpdateRoleData().getName() != null) {
            role.setName(dto.getUpdateRoleData().getName());
        }

        if (dto.getUpdateRoleData().getPermission() != null) {
            role.setPermission(stringifyPermission(dto.getUpdateRoleData().getPermission()));
        }

        return roleRepository.save(role);
    }

    public long getUserCountByRole(Long roleId) {
        return roleRepository.countUsersByRoleId(roleId);
    }

    @Transactional
    public void deleteRole(Role role) {
        roleRepository.delete(role);
    }

    public long getUserCountWithAdminRole() {
        return roleRepository.countUsersWithAdminRole();
    }

    public boolean isRoleNameExist(String roleName) {
        return roleRepository.existsByName(roleName);
    }

    private String stringifyPermission(List<String> permission) {
        // 使用 Jackson 或 Gson 等 JSON 庫將 List<String> 轉換為 JSON 字符串
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(permission);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}