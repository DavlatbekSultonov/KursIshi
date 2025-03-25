package com.example.kursishi.request;

import com.example.kursishi.role.Role;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UserDtoReq(
        @NotNull() String name,
        @NotNull() String phoneNumber,
        @NotNull() LocalDate birthDate,
        @NotNull() String role,
        @NotNull() String password
) {
}

