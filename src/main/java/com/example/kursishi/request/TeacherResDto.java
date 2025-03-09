package com.example.kursishi.request;

public record TeacherResDto
        (
                Long id,
                String name,
                String surname,
                String phoneNumber,
                String telegramLink,
                String articleLink,

                String description,
                String imageUrl
        ) {
}
