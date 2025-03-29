    package com.example.kursishi.entity;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    import org.hibernate.annotations.CreationTimestamp;
    import org.hibernate.annotations.UpdateTimestamp;

    import java.time.LocalDateTime;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Table
    @Entity(name = "teacher")
    public class Teacher {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private String surname;
        private String phoneNumber;
        private String position;
        private String telegramLink;
        private String articleLink;

        @Column(columnDefinition = "TEXT")
        private String description;

        private String imageUrl;

        @CreationTimestamp
        private LocalDateTime createdAt;

        @UpdateTimestamp
        private LocalDateTime lastUpdatedDate;

        private boolean deleted;

    }
