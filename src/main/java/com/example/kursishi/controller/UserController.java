package com.example.kursishi.controller;

import com.example.kursishi.common.ApiResponse;
import com.example.kursishi.repository.UserRepository;
import com.example.kursishi.request.SignInDto;
import com.example.kursishi.request.TeacherReqDto;
import com.example.kursishi.request.UserDto;
import com.example.kursishi.role.User;
import com.example.kursishi.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/create")
    public ApiResponse create(@RequestBody UserDto userDto){
        User user = new User();
        ApiResponse apiResponse = userService.create(userDto, user);

        return ApiResponse.builder().data(apiResponse).message("sign in succesfully").build();
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/update")
    public ApiResponse update(@PathVariable Long id, @RequestBody UserDto userDto){
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        ApiResponse apiResponse = userService.create(userDto, user);
        return ApiResponse.builder().data(apiResponse).build();

    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        userRepository.delete(user);
    }

    @PostMapping("/sign-in")
    public ApiResponse signIn(@RequestBody SignInDto signInDto){
        ApiResponse apiResponse = userService.signIn(signInDto);
        return ApiResponse.builder().data(apiResponse).build();
    }

}
