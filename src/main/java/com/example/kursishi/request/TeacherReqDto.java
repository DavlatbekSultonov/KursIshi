package com.example.kursishi.request;

public record TeacherReqDto
        (
                 String name,
                 String surname,
                 String phoneNumber,
                 String telegramLink,
                 String position,
                 String articleLink,

                 String description,
                 String imageUrl
        )
{
}
