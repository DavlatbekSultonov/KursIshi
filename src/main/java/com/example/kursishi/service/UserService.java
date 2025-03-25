package com.example.kursishi.service;

import com.example.kursishi.common.ApiResponse;
import com.example.kursishi.mapper.UserMapper;
import com.example.kursishi.repository.UserRepository;
import com.example.kursishi.request.UserDtoReq;
import com.example.kursishi.request.UserResponseDto;
import com.example.kursishi.role.User;
import jakarta.security.auth.message.MessageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;


    // Creating User

    public ApiResponse create(UserDtoReq userDtoReq) {
        User user = new User();
        userMapper.toUser(userDtoReq, user);
        userRepository.save(user);
        return new ApiResponse(
                "USER_SAVED_SECCESSFULLY",
                true,
                user
        );
    }


    //updating user's details
    public ApiResponse update(UserDtoReq userDtoReq, Long id) {
        User user = getUserById(id);
        userMapper.toUser(userDtoReq, user);
        userRepository.save(user);
        return new ApiResponse(
                "USER_SAVED_SUCCESSFULLY",
                true,
                user
        );
    }

    // Get single to show user
    public ApiResponse getSingle(Long id) {
        User user = getUserById(id);
        UserResponseDto dto = userMapper.toDto(user);
        return ApiResponse.builder()
                .status(true)
                .data(dto).build();
    }


    // Get all users to show users it is accessible for Admin
    public ApiResponse getAll() {
        List<UserResponseDto> data = userRepository.findAll().stream()
                .map(userMapper::toDto).toList();
        return ApiResponse.builder().status(true).data(data).build();
    }


    // Delete user by id
    public ApiResponse delete(Long id) {
        User user = getUserById(id);
        user.setDeleted(true);
        userRepository.save(user);
        return ApiResponse.builder().status(true).message(
                "SUCCESSFULLY_DELETED"
        ).build();
    }


    // Get user object by id
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new UsernameNotFoundException("USER_NOT_FOUND"));
    }

}
