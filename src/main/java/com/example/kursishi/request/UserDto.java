package com.example.kursishi.request;

import com.example.kursishi.role.Role;

public record UserDto (
    String name,
    String surname,
    String username,
    String password,
    Role role
){
}
