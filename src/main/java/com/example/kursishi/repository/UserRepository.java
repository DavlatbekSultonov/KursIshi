package com.example.kursishi.repository;

import com.example.kursishi.role.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserDetailPhoneNumber(String phoneNumber);

    User findUserByIdAndDeletedIsFalse(Long id);

    User findUserById(Long id);

    List<User> findAllByDeletedFalse();
}

