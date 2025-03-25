package com.example.kursishi.repository;

import com.example.kursishi.role.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetail, Long> {
    UserDetail getUserDetailById(Long id);
}
