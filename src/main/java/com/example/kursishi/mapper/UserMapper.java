package com.example.kursishi.mapper;

import com.example.kursishi.repository.RoleRepository;
import com.example.kursishi.request.UserDtoReq;
import com.example.kursishi.request.UserResponseDto;
import com.example.kursishi.role.RolName;
import com.example.kursishi.role.User;
import com.example.kursishi.role.UserDetail;
import com.example.kursishi.service.UserDetailService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMapper {
    private final PasswordEncoder passwordEncoder;
    private final UserDetailService userDetailService;
    private final RoleRepository roleRepository;

    // to User
    public void toUser(UserDtoReq userDtoReq, User user) {

        boolean isPresent = false;
        for (RolName value : RolName.values()) {
            if (value.toString().equals(userDtoReq.role())) {
                isPresent = true;
                break;
            }
        }
        if (!isPresent)
            throw new EntityNotFoundException("Rol not found");
        user.setUserRole(roleRepository.findRoleByName(RolName.valueOf(userDtoReq.role())));

        UserDetail userDetail = user.getUserDetail();
        if (user.getUserDetail() == null) {
            userDetail = new UserDetail();
        }
        if (userDtoReq.name() != null)
            userDetail.setName(userDtoReq.name());
        if (userDtoReq.birthDate() != null)
            userDetail.setBirthDate(userDtoReq.birthDate());
        if (userDtoReq.phoneNumber() != null)
            userDetail.setPhoneNumber(userDtoReq.phoneNumber());
        user.setUserDetail(userDetail);
        if (userDtoReq.password() != null && userDetail.getId() == null)
            user.setPassword(passwordEncoder.encode(userDtoReq.password()));

        userDetailService.save(userDetail);

    }

    // to Dto
    public UserResponseDto toDto(User user) {
        return new UserResponseDto(user.getUserDetail().getName(),
                user.getUserDetail().getPhoneNumber(),
                user.getUserDetail().getBirthDate(),
                user.getUserRole());
    }
}

