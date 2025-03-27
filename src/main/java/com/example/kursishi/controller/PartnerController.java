package com.example.kursishi.controller;

import com.example.kursishi.common.ApiResponse;
import com.example.kursishi.common.CheckRole;
import com.example.kursishi.common.RestConstant;
import com.example.kursishi.request.PartnersReqDto;
import com.example.kursishi.role.RolName;
import com.example.kursishi.service.PartnersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping()
@Tag(name = "Hamkorlar boshqaruvi->", description = "(Hamkorlarni yaratish, yangilash, ko‘rish va o‘chirish API-lari)")
public class PartnerController {
    private final PartnersService partnersService;
//
    @CheckRole({RolName.ADMIN})
    @PostMapping(RestConstant.BASE_SECURE_PATH+"create/partner")
    @Operation(summary = "Yangi hamkor yaratish->", description = "(Bu API faqat administrator tomonidan ishlatilishi mumkin.)")
    public ResponseEntity<ApiResponse> create(@RequestBody PartnersReqDto partnersReqDto){
        ApiResponse apiResponse = partnersService.create(partnersReqDto);
        return ResponseEntity.ok(apiResponse);
    }

    @CheckRole({RolName.ADMIN})
    @PutMapping(RestConstant.BASE_SECURE_PATH+"update/partner/{id}")
    @Operation(summary = "Hamkor ma’lumotlarini yangilash->", description = "(Administrator mavjud hamkor ma’lumotlarini yangilashi mumkin.)")
    public ResponseEntity<ApiResponse> update(@PathVariable("id") Long id, @RequestBody PartnersReqDto partnersReqDto){
        ApiResponse update = partnersService.update(id, partnersReqDto);
        return ResponseEntity.ok(update);
    }




    @GetMapping(RestConstant.BASE_OPEN_APIS+"getPartner/{id}")
    @Operation(summary = "Hamkorni ID bo‘yicha olish->", description = "(Har qanday foydalanuvchi hamkor ID'si bo‘yicha ma’lumot olishi mumkin.)")
    public ResponseEntity<ApiResponse> getById(@PathVariable("id") Long id){

        ApiResponse byId = partnersService.getById(id);
        return ResponseEntity.ok(byId);
    }

    @GetMapping(RestConstant.BASE_OPEN_APIS+"getAll/partners")
    @Operation(summary = "Barcha hamkorlarni olish->", description = "(Har qanday foydalanuvchi barcha hamkorlar ro‘yxatini olishi mumkin.)")
    public ResponseEntity<ApiResponse> getAll(){
        ApiResponse all = partnersService.getAll();
        return ResponseEntity.ok(all);
    }

    @CheckRole({RolName.ADMIN})
    @DeleteMapping(RestConstant.BASE_SECURE_PATH+"delete/partner/{id}")
    @Operation(summary = "Hamkorni o‘chirish->", description = "(Faqat administrator mavjud hamkorni o‘chira oladi.)")
    public ResponseEntity<ApiResponse> delete(@PathVariable("id") Long id){
        ApiResponse delete = partnersService.delete(id);
        return ResponseEntity.ok(delete);
    }

}
