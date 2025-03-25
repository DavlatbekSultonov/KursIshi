package com.example.kursishi.common;

import com.example.kursishi.role.RolName;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckRole {
    RolName[] value();
}

