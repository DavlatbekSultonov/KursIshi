package com.example.kursishi.controller;


import com.example.kursishi.common.ApiResponse;
import com.example.kursishi.common.CheckRole;
import com.example.kursishi.common.RestConstant;
import com.example.kursishi.request.TeacherReqDto;
import com.example.kursishi.role.RolName;
import com.example.kursishi.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping()
@Tag(name = "O'qituvchilar boshqaruvi->", description = "(O'qituvchilarni yaratish, yangilash, o‘chirish va ko‘rish API-lari)")
public class TeacherController {

    private final TeacherService teacherService;

    /**
     * O‘qituvchi yaratish
     * @param teacherReqDto - O‘qituvchi ma’lumotlari
     * @return ApiResponse - Yangi o‘qituvchi
     */
    @CheckRole({RolName.ADMIN})
    @PostMapping(RestConstant.BASE_SECURE_PATH + "create/Teacher")
    @Operation(summary = "O‘qituvchi yaratish->", description = "(Bu API faqat administratorga o‘qituvchi yaratishga ruxsat beradi.)")
    public ResponseEntity<ApiResponse> createTeacher(@RequestBody TeacherReqDto teacherReqDto) {
        ApiResponse response = teacherService.create(teacherReqDto);
        return ResponseEntity.ok(response);
    }

    /**
     * O‘qituvchini yangilash
     * @param id - O‘qituvchining ID'si
     * @param teacherReqDto - Yangilanishi kerak bo‘lgan ma’lumotlar
     * @return ApiResponse - Yangilangan o‘qituvchi
     */
    @CheckRole({RolName.ADMIN})
    @PostMapping(RestConstant.BASE_SECURE_PATH + "update/Teacher/{id}")
    @Operation(summary = "O‘qituvchini yangilash->", description = "(Administrator mavjud o‘qituvchi ma’lumotlarini yangilashi mumkin.)")
    public ResponseEntity<ApiResponse> updateTeacher(@PathVariable("id") Long id, @RequestBody TeacherReqDto teacherReqDto) {
        ApiResponse response = teacherService.update(id, teacherReqDto);
        return ResponseEntity.ok(response);
    }

    /**
     * Berilgan ID bo‘yicha o‘qituvchini olish
     * @param id - O‘qituvchining ID'si
     * @return ApiResponse - O‘qituvchi ma’lumotlari
     */
    @GetMapping(RestConstant.BASE_OPEN_APIS+"{id}")
    @Operation(summary = "O‘qituvchini ID bo‘yicha olish->", description = "(Har qanday foydalanuvchi o‘qituvchi ID'si bo‘yicha ma’lumotni olishi mumkin.)")
    public ResponseEntity<ApiResponse> getTeacherById(@PathVariable("id") Long id) {
        ApiResponse response = teacherService.getId(id);
        return ResponseEntity.ok(response);
    }

    /**
     * Barcha o‘qituvchilarni olish
     * @return ApiResponse - O‘qituvchilar ro‘yxati
     */
    @GetMapping(RestConstant.BASE_OPEN_APIS)
    @Operation(summary = "Barcha o‘qituvchilarni olish->", description = "(Har qanday foydalanuvchi barcha o‘qituvchilarning ro‘yxatini olishi mumkin.)")
    public ResponseEntity<ApiResponse> getAllTeachers() {
        ApiResponse response = teacherService.getAll();
        return ResponseEntity.ok(response);
    }

    /**
     * O‘qituvchini o‘chirish
     * @param id - O‘qituvchining ID'si
     * @return ApiResponse - O‘chirilgan o‘qituvchi
     */

    @CheckRole({RolName.ADMIN})
    @DeleteMapping(RestConstant.BASE_SECURE_PATH+"delete/Teacher/{id}")
    @Operation(summary = "O‘qituvchini o‘chirish->", description = "(Faqat administrator mavjud o‘qituvchini o‘chira oladi.)")
    public ResponseEntity<ApiResponse> deleteTeacher(@PathVariable("id") Long id) {
        ApiResponse response = teacherService.delete(id);
        return ResponseEntity.ok(response);
    }
}
