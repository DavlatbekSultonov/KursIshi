package com.example.kursishi.repository;

import com.example.kursishi.entity.Partners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnersRepository extends JpaRepository<Partners,Long> {
}
