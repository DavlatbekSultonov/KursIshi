package com.example.kursishi.controller;

import com.example.kursishi.common.ApiResponse;
import com.example.kursishi.common.CheckRole;
import com.example.kursishi.common.RestConstant;
import com.example.kursishi.request.PartnersReqDto;
import com.example.kursishi.role.RolName;
import com.example.kursishi.service.PartnersService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping()
public class PartnerController {
    private final PartnersService partnersService;

    @CheckRole({RolName.ADMIN})
    @PostMapping(RestConstant.BASE_SECURE_PATH+"create/partner")
    public ResponseEntity<ApiResponse> create(@RequestBody PartnersReqDto partnersReqDto){
        ApiResponse apiResponse = partnersService.create(partnersReqDto);
        return ResponseEntity.ok(apiResponse);
    }

    @CheckRole({RolName.ADMIN})
    @PutMapping(RestConstant.BASE_SECURE_PATH+"update/partner/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable Long id, @RequestBody PartnersReqDto partnersReqDto){
        ApiResponse update = partnersService.update(id, partnersReqDto);
        return ResponseEntity.ok(update);
    }


    @GetMapping(RestConstant.BASE_OPEN_APIS+"getPartner/{id}")
    public ResponseEntity<ApiResponse> getById(@PathVariable Long id){

        ApiResponse byId = partnersService.getById(id);
        return ResponseEntity.ok(byId);
    }

    @GetMapping(RestConstant.BASE_OPEN_APIS+"getAll")
    public ResponseEntity<ApiResponse> getAll(){
        ApiResponse all = partnersService.getAll();
        return ResponseEntity.ok(all);
    }

    @CheckRole({RolName.ADMIN})
    @DeleteMapping(RestConstant.BASE_SECURE_PATH+"delete/Partner/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id){
        ApiResponse delete = partnersService.delete(id);
        return ResponseEntity.ok(delete);
    }

}
