package com.example.kursishi.request;

import java.time.LocalDateTime;

public record NewsResDto
        (
                Long id,
                String title,
                String description,
                String imageUrl,
                LocalDateTime createTime
        ) {
}
