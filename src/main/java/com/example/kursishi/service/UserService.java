package com.example.kursishi.service;

import com.example.kursishi.common.ApiResponse;
import com.example.kursishi.repository.UserRepository;
import com.example.kursishi.request.SignInDto;
import com.example.kursishi.request.UserDto;
import com.example.kursishi.role.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public ApiResponse create(UserDto userDto,User user){
        user.setName(userDto.name());
        user.setSurname(userDto.surname());
        user.setUsername(userDto.username());
        user.setPassword(userDto.password());
        user.setRole(userDto.role());

        User save = userRepository.save(user);

        return ApiResponse.builder().data(save).build();
    }

    public ApiResponse signIn(SignInDto signInDto){
        for (User user : userRepository.findAll()) {
            if (user.getUsername().equals(signInDto.username()) &&
                    passwordEncoder.matches(signInDto.password(), user.getPassword())) {
                return ApiResponse.builder().message("sign in successfully").build();}
        }
        return ApiResponse.builder().message("password or username error").build();
    }


}
