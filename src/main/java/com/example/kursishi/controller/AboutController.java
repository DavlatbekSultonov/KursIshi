package com.example.kursishi.controller;

import com.example.kursishi.common.ApiResponse;
import com.example.kursishi.common.CheckRole;
import com.example.kursishi.common.RestConstant;
import com.example.kursishi.request.AboutReqDto;
import com.example.kursishi.role.RolName;
import com.example.kursishi.service.AboutService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
@Tag(name = "Loyiha haqida->", description = "(Loyiha haqida ma'lumotlarni boshqarish API-lari)")
public class AboutController {

    private final AboutService aboutService;

    // GET ALL
    @GetMapping(RestConstant.BASE_OPEN_APIS+"aboutAll")
    @Operation(
            summary = "Barcha 'About' ma'lumotlarini olish->",
            description = "(Har qanday foydalanuvchi loyiha haqida barcha ma'lumotlarni olishi mumkin.)"
    )
    public ResponseEntity<ApiResponse> getAll() {
        ApiResponse response = aboutService.getAll();
        return ResponseEntity.ok(response);
    }

    // UPDATE

    @CheckRole(RolName.ADMIN)
    @PutMapping(RestConstant.BASE_SECURE_PATH+"update/About/{id}")
    @Operation(
            summary = "'About' ma'lumotlarini yangilash->",
            description = "(Bu API faqat admin uchun.)")
    public ResponseEntity<ApiResponse> update(@PathVariable("id") Long id, @RequestBody AboutReqDto aboutReqDto) {
        ApiResponse response = aboutService.update(id, aboutReqDto);
        return ResponseEntity.ok(response);
    }

}

