package com.example.kursishi.controller;

import com.example.kursishi.common.ApiResponse;
import com.example.kursishi.request.AboutReqDto;
import com.example.kursishi.service.AboutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/about")
@RequiredArgsConstructor
public class AboutController {

    private final AboutService aboutService;

    // GET ALL
    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAll() {
        ApiResponse response = aboutService.getAll();
        return ResponseEntity.ok(response);
    }

    // UPDATE

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable Long id, @RequestBody AboutReqDto aboutReqDto) {
        ApiResponse response = aboutService.update(id, aboutReqDto);
        return ResponseEntity.ok(response);
    }

}

