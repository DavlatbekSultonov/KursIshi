package com.example.kursishi.request;

import com.example.kursishi.role.User;

public record AuthResponse(User user, String token) {
}

