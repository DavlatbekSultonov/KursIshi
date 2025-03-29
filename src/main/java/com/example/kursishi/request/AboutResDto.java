package com.example.kursishi.request;

import jakarta.validation.constraints.NotNull;

public record AboutResDto (
    String name,
    String description,
    String phoneNumber,
    String telegramBot,
    String imageUrl,
    String instagram,
    String youtube
)
{
}
