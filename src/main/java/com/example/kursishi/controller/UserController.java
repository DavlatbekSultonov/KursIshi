package com.example.kursishi.controller;

import com.example.kursishi.common.ApiResponse;
import com.example.kursishi.common.CheckRole;
import com.example.kursishi.common.RestConstant;
import com.example.kursishi.request.UserDtoReq;
import com.example.kursishi.role.RolName;
import com.example.kursishi.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.groups.Default;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping()
public class UserController {

    private final UserService userService;

    @Tag(name = "Creating user ", description = "It is accessible for super admin and admin")
    @CheckRole({RolName.ADMIN})
    @PostMapping(RestConstant.BASE_SECURE_PATH + "user/")
    public HttpEntity<?> create(@RequestBody UserDtoReq userDtoReq) {
        ApiResponse apiResponse = userService.create(userDtoReq);
        return ResponseEntity.ok(apiResponse);
    }

    @Tag(name = "Get single user to show users ", description = "It is accessible for all users")
    @GetMapping(RestConstant.BASE_OPEN_APIS + "user/{id}")
    public HttpEntity<?> getSingle(@PathVariable Long id) {
        ApiResponse apiResponse = userService.getSingle(id);
        return ResponseEntity.ok(apiResponse);
    }


    @Tag(name = "Updating user details ", description = "It is accessible for only super admin and admin")
    @CheckRole({RolName.ADMIN})
    @PutMapping(RestConstant.BASE_SECURE_PATH + "user/update/{id}")
    public HttpEntity<?> update(@PathVariable Long id,@RequestBody UserDtoReq userDtoReq) {
        ApiResponse apiResponse = userService.update(userDtoReq, id);
        return ResponseEntity.ok(apiResponse);
    }

    @Tag(name = "deleting user", description = "It is accessible for super admin and admin")
    @CheckRole({RolName.ADMIN, RolName.SUPER_ADMIN})
    @DeleteMapping(RestConstant.BASE_SECURE_PATH + "user/delete/{id}")
    public HttpEntity<?> delete(@PathVariable Long id) {
        ApiResponse apiResponse = userService.delete(id);
        return ResponseEntity.ok(apiResponse);
    }

    @Tag(name = "Get all users", description = "It is accessible for super admin and admin")
    @CheckRole({RolName.ADMIN, RolName.SUPER_ADMIN})
    @GetMapping(RestConstant.BASE_SECURE_PATH + "user/all")
    public HttpEntity<?> getAll() {
        ApiResponse apiResponse = userService.getAll();
        return ResponseEntity.ok(apiResponse);
    }



}
