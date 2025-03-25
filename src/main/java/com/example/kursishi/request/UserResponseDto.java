package com.example.kursishi.request;

import com.example.kursishi.role.Role;

import java.time.LocalDate;

public record UserResponseDto(
        String name,
        String phoneNumber,
        LocalDate birtDate,
        Role role
) {
}

