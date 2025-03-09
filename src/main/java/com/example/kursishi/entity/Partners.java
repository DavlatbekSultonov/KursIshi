package com.example.kursishi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hamkorlar")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Partners {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomi;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    private Attachment image;
}
