package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.dto.*;
import com.example.demo.entity.*;
import com.example.demo.exception.ExpectedErrorResponseModel;
import com.example.demo.exception.UnexpectedErrorResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.annotation.Secured;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginSuccessResponseModel> login(@RequestBody LoginModel body) {
        LoginSuccessResponseModel result = userService.login(body);
        // Set JWT cookie if needed
        return ResponseEntity.ok(result);
    }

    // @GetMapping("/info")
    // // @Secured("ROLE_USER")
    // public ResponseEntity<GetUserInfoSuccessResponseModel> getUserInfo(@RequestAttribute("user") JwtPayloadType user) {
    //     Optional<User> result = userService.getUserByIdWithRolePermission(user.getUserId());
    //     return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(400).body(null));
    // }

    // @PostMapping("/")
    // // @Secured("ROLE_ADMIN")
    // public ResponseEntity<SubmitSuccessResponseModel> createUser(
    //         @RequestAttribute("user") JwtPayloadType user,
    //         @RequestBody CreateUserModel body,
    //         @RequestParam("action") String action,
    //         @RequestParam(value = "bpexe_main_id", required = false) Integer bpExeMainId) {
    //     if (!List.of("OH", "TORV").contains(action)) {
    //         throw new ExpectedErrorResponseModel("W008");
    //     }

    //     BPSubmitDto inputData = new BPSubmitDto(bpExeMainId, user.getEmployeeId(), body.getPayload().getEmployeeId(),
    //             "Create User", action, body.getDescription(), newSnapshot);
    //     userService.isUserExist(body.getPayload().getEmployeeId());
    //     SubmitSuccessResponseModel result = userService.submit(inputData);
    //     return ResponseEntity.ok(result);
    // }

    // @PatchMapping("/{user_id}")
    // // @Secured("ROLE_ADMIN")
    // public ResponseEntity<SubmitSuccessResponseModel> updateUser(
    //         @RequestAttribute("user") JwtPayloadType user,
    //         @PathVariable("user_id") Long userId,
    //         @RequestBody UpdateUserModel body,
    //         @RequestParam("action") String action,
    //         @RequestParam(value = "bpexe_main_id", required = false) Integer bpExeMainId) {
    //     if (!List.of("OH", "TORV").contains(action)) {
    //         throw new ExpectedErrorResponseModel("W008");
    //     }

    //     Optional<User> userWithRolePermission = userService.getUserByIdWithRolePermission(userId);
    //     if (userWithRolePermission.isEmpty()) {
    //         throw new ExpectedErrorResponseModel("D001");
    //     }

    //     BPSubmitDto inputData = new BPSubmitDto(bpExeMainId, user.getEmployeeId(), userId.toString(),
    //             "Edit User", action, body.getDescription(), oldSnapshot, newSnapshot);
    //     SubmitSuccessResponseModel result = userService.submit(inputData);
    //     return ResponseEntity.ok(result);
    // }

    // @PostMapping("/delete")
    // // @Secured("ROLE_ADMIN")
    // public ResponseEntity<SubmitSuccessResponseModel> deleteUser(
    //         @RequestAttribute("user") JwtPayloadType user,
    //         @RequestBody DeleteUserModel body,
    //         @RequestParam("action") String action,
    //         @RequestParam(value = "bpexe_main_id", required = false) Integer bpExeMainId) {
    //     Optional<User> userWithRolePermission = userService.getUserByIdWithRolePermission(body.getId());
    //     if (userWithRolePermission.isEmpty()) {
    //         throw new ExpectedErrorResponseModel("D001");
    //     }

    //     BPSubmitDto inputData = new BPSubmitDto(bpExeMainId, user.getEmployeeId(), body.getId().toString(),
    //             "Delete User", action, body.getDescription(), oldSnapshot, newSnapshot);
    //     SubmitSuccessResponseModel result = userService.submit(inputData);
    //     return ResponseEntity.ok(result);
    // }

    // @GetMapping("/search")
    // // @Secured("ROLE_USER")
    // public ResponseEntity<GetUserListByNameOrEmployeeIdSuccessResponseModel> getUserListByNameOrEmployeeId(
    //         @RequestParam("page") int page,
    //         @RequestParam("limit") int limit,
    //         @RequestParam(value = "keyword", required = false) String keyword) {
    //     GetUserListByNameOrEmployeeIdSuccessResponseModel result = userService.getUserListByKeyword(keyword, page, limit);
    //     return ResponseEntity.ok(result);
    // }

    // @GetMapping("/search/report")
    // // @Secured("ROLE_USER")
    // public ResponseEntity<GetUserListByNameOrEmployeeIdReportSuccessResponseModel> getUserListByNameOrEmployeeIdReport(
    //         @RequestParam(value = "keyword", required = false) String keyword) {
    //     GetUserListByNameOrEmployeeIdReportSuccessResponseModel result = userService.getUserListByKeywordReport(keyword);
    //     return ResponseEntity.ok(result);
    // }

    // @GetMapping("/{user_id}")
    // // @Secured("ROLE_USER")
    // public ResponseEntity<GetUserByIdSuccessResponseModel> getUserById(@PathVariable("user_id") Long userId) {
    //     Optional<User> result = userService.getUserByIdWithRolePermission(userId);
    //     return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(400).body(null));
    // }

    // @GetMapping("/")
    // // @Secured("ROLE_USER")
    // public ResponseEntity<GetUserListSuccessResponseModel> getUserList(
    //         @RequestParam("page") int page,
    //         @RequestParam("limit") int limit) {
    //     GetUserListSuccessResponseModel result = userService.getUserList(page, limit);
    //     return ResponseEntity.ok(result);
    // }
}