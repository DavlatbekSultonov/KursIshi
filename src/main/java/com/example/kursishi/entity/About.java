package com.example.kursishi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "kafedra")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class About {

    @Id
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String phoneNumber;

//    @OneToOne(cascade = CascadeType.ALL)
    private String imageUrl;

    private String telegram;


}

