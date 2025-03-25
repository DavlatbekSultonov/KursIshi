package com.example.kursishi.repository;

import com.example.kursishi.role.RolName;
import com.example.kursishi.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {


    Role findRoleByName(RolName name);
}

