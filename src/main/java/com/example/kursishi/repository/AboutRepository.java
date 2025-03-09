package com.example.kursishi.repository;

import com.example.kursishi.entity.About;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRepository extends JpaRepository<About,Long> {

}
