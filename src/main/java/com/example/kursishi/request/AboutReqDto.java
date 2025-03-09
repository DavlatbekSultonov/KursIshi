package com.example.kursishi.request;

import jakarta.validation.constraints.NotNull;

public record AboutReqDto(

    String name,
    String description,
    @NotNull String phoneNumber,
    @NotNull String telegramBot,
    @NotNull String imageUrl
){
}
