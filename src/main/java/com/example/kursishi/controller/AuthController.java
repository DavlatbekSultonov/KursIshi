package com.example.kursishi.controller;

import com.example.kursishi.request.AuthRequest;
import com.example.kursishi.request.ResponseData;
import com.example.kursishi.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "Foydalanuvchilarni autentifikatsiya qilish uchun API")
public class AuthController {
    private final AuthService authService;


    /**
     * This API is designed for authorizing User
     *
     * @param authRequest has 2 variable:
     *       .             1-phoneNumber -> should be String
     *                    2-password -> should be String
     * @return
     */
    @PostMapping("/sign-in")
    @Operation(
            summary = "Foydalanuvchini tizimga kiritish (sign-in)->",
            description = "(Ushbu API foydalanuvchini tizimga kirishini ta’minlaydi.)")
    private ResponseData<?> signIn(@RequestBody AuthRequest authRequest) throws ChangeSetPersister.NotFoundException {
        return authService.authenticate(authRequest);
    }
}

