package com.example.kursishi.controller;

import com.example.kursishi.common.ApiResponse;
import com.example.kursishi.common.CheckRole;
import com.example.kursishi.common.RestConstant;
import com.example.kursishi.request.NewsReqDto;
import com.example.kursishi.role.RolName;
import com.example.kursishi.service.NewsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping()
@Tag(name = "Yangiliklar boshqaruvi ->", description = "(Yangiliklarni yaratish, yangilash, o‘chirish va ko‘rish API-lari)")
public class NewsController {

    private final NewsService newsService;

    /**
     * Yangilik yaratish
     * @param newsReqDto - Yangilik ma’lumotlari
     * @return ApiResponse - Yangi yaratilgan yangilik
     */
    @CheckRole({RolName.ADMIN})
    @PostMapping(RestConstant.BASE_SECURE_PATH + "create/News")
    @Operation(summary = "Yangilik yaratish ->", description = "(Bu API faqat administratorga yangilik qo‘shishga ruxsat beradi.)")
    public ResponseEntity<ApiResponse> createNews(@RequestBody NewsReqDto newsReqDto) {
        ApiResponse response = newsService.create(newsReqDto);
        return ResponseEntity.ok(response);
    }

    /**
     * Yangilikni yangilash
     * @param id - Yangilik ID'si
     * @param newsReqDto - Yangilanishi kerak bo‘lgan ma’lumotlar
     * @return ApiResponse - Yangilangan yangilik
     */
    @CheckRole({RolName.ADMIN})
    @PutMapping(RestConstant.BASE_SECURE_PATH + "update/News/{id}")
    @Operation(summary = "Yangilikni yangilash ->", description = "(Administrator mavjud yangilikni yangilashi mumkin.)")
    public ResponseEntity<ApiResponse> updateNews(@PathVariable Long id, @RequestBody NewsReqDto newsReqDto) {
        ApiResponse response = newsService.update(newsReqDto, id);
        return ResponseEntity.ok(response);
    }

    /**
     * ID bo‘yicha yangilikni olish
     * @param id - Yangilik ID'si
     * @return ApiResponse - Yangilik ma’lumotlari
     */
    @GetMapping(RestConstant.BASE_OPEN_APIS + "news/{id}")
    @Operation(summary = "Yangilikni ID bo‘yicha olish ->", description = "(Har qanday foydalanuvchi ID bo‘yicha yangilikni ko‘rishi mumkin.)")
    public ResponseEntity<ApiResponse> getNewsById(@PathVariable Long id) {
        ApiResponse response = newsService.getById(id);
        return ResponseEntity.ok(response);
    }

    /**
     * Barcha yangiliklarni olish
     * @return ApiResponse - Yangiliklar ro‘yxati
     */
    @GetMapping(RestConstant.BASE_OPEN_APIS + "news")
    @Operation(summary = "Barcha yangiliklarni olish ->", description = "(Har qanday foydalanuvchi yangiliklar ro‘yxatini ko‘rishi mumkin.)")
    public ResponseEntity<ApiResponse> getAllNews() {
        ApiResponse response = newsService.getAll();
        return ResponseEntity.ok(response);
    }

    /**
     * Yangilikni o‘chirish
     * @param id - Yangilik ID'si
     * @return ApiResponse - O‘chirilgan yangilik
     */
    @CheckRole({RolName.ADMIN})
    @DeleteMapping(RestConstant.BASE_SECURE_PATH + "delete/News/{id}")
    @Operation(summary = "Yangilikni o‘chirish ->", description = "(Faqat administrator yangilikni o‘chira oladi.)")
    public ResponseEntity<ApiResponse> deleteNews(@PathVariable Long id) {
        ApiResponse response = newsService.delete(id);
        return ResponseEntity.ok(response);
    }
}
