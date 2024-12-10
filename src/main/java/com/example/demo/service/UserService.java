package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.enumeration.BooleanEnum;
import com.example.demo.exception.ExpectedErrorResponseModel;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.JwtUtil;
import com.example.demo.util.LoggerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private LoggerUtil loggerUtil;

    public LoginSuccessResponseModel login(LoginServiceDto dto) {
        loggerUtil.debug("login service " + dto.getEmployeeId());

        // Perform AD login (assuming adLogin is a method that performs AD login)
        AdResponse adResponse = adLogin(dto.getEmployeeId(), dto.getPassword());

        Optional<User> userOpt = userRepository.findByEmployeeId(dto.getEmployeeId());
        if (userOpt.isEmpty()) {
            throw new ExpectedErrorResponseModel("B085");
        }

        User user = userOpt.get();
        if (user.getName() == null) {
            user.setName(adResponse.getName());
            user.setEmail(adResponse.getMail());
            userRepository.save(user);
        }

        String jwt = jwtUtil.generateToken(user);
        return new LoginSuccessResponseModel(jwt);
    }

    @Transactional
    public User createUser(CreateUserServiceDto dto) {
        loggerUtil.debug("createUser service " + dto.getEmployeeId());

        Role role = roleRepository.findById(dto.getRoleId())
                .orElseThrow(() -> new ExpectedErrorResponseModel("D060"));

        if (isUserExist(dto.getEmployeeId())) {
            throw new ExpectedErrorResponseModel("B018");
        }

        User newUser = new User();
        newUser.setEmployeeId(dto.getEmployeeId());
        newUser.setEnableStatus(BooleanEnum.TRUE);
        newUser.setMemo(dto.getMemo());
        newUser.setRole(role);

        return userRepository.save(newUser);
    }

    @Transactional
    public User updateUser(UpdateUserServiceDto dto) {
        loggerUtil.debug("updateUser service " + dto.getUserId());

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ExpectedErrorResponseModel("D001"));

        Role role = null;
        if (dto.getRoleId() != null) {
            role = roleRepository.findById(dto.getRoleId())
                    .orElseThrow(() -> new ExpectedErrorResponseModel("D060"));
        }

        user.setMemo(dto.getMemo());
        if (role != null) {
            user.setRole(role);
        }

        return userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long userId) {
        loggerUtil.debug("deleteUser service " + userId);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ExpectedErrorResponseModel("D001"));

        userRepository.delete(user);
    }

    public List<User> getUserListByKeyword(GetUserListByKeywordServiceDto dto) {
        loggerUtil.debug("getUserListByKeyword service " + dto.getKeyword());

        return userRepository.findAllWithRoleByKeyword(dto.getKeyword());
    }

    public GetUserListByKeywordReportResponseDto getUserListByKeywordReport(GetUserListByKeywordReportServiceDto dto) {
        loggerUtil.debug("getUserListByKeywordReport service " + dto.getKeyword());

        // 強制轉型
        GetUserListByKeywordServiceDto keywordDto = (GetUserListByKeywordServiceDto) dto;

        List<User> users = getUserListByKeyword(keywordDto);
        String excelBuffer = createUserListReport(users); // Assuming createUserListReport is a method that generates the report

        GetUserListByKeywordReportResponseDto response = new GetUserListByKeywordReportResponseDto();
        response.setData(users);
        response.setBase64File(excelBuffer);
        return response;
    }

    public Optional<User> getUserById(Long id) {
        loggerUtil.debug("getUserById service " + id);

        return userRepository.findById(id);
    }

    public Optional<User> getUserByIdWithRolePermission(Long id) {
        loggerUtil.debug("getUserByIdWithRolePermission service " + id);

        return userRepository.findByIdWithRole(id);
    }

    public List<User> getUserList(PaginationDto dto) {
        loggerUtil.debug("getUserList service " + dto.getPage());

        return userRepository.findAllWithRoleOrderedByIdDesc();
    }

    public boolean isUserExist(String employeeId) {
        loggerUtil.debug("isUserExist service " + employeeId);

        return userRepository.findByEmployeeId(employeeId).isPresent();
    }

    // Assuming adLogin is a method that performs AD login
    private AdResponse adLogin(String employeeId, String password) {
        // Implement AD login logic here
        return new AdResponse();
    }

    // Assuming createUserListReport is a method that generates the report
    private String createUserListReport(List<User> users) {
        // Implement report generation logic here
        return "";
    }
}