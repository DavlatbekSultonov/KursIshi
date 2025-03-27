package com.example.kursishi.controller;

import com.example.kursishi.common.ApiResponse;
import com.example.kursishi.common.CheckRole;
import com.example.kursishi.common.RestConstant;
import com.example.kursishi.request.PartnersReqDto;
import com.example.kursishi.role.RolName;
import com.example.kursishi.service.PartnersService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping()
public class PartnerController {
    private final PartnersService partnersService;

    @Tag(name = "Creating partner -> ", description = "(It is accessible for admin)")
    @CheckRole({RolName.ADMIN})
    @PostMapping(RestConstant.BASE_SECURE_PATH+"create/partner")
    public ResponseEntity<ApiResponse> create(@RequestBody PartnersReqDto partnersReqDto){
        ApiResponse apiResponse = partnersService.create(partnersReqDto);
        return ResponseEntity.ok(apiResponse);
    }

    @Tag(name = "Updating partner details -> ", description = "(It is accessible for admin)")
    @CheckRole({RolName.ADMIN})
    @PutMapping(RestConstant.BASE_SECURE_PATH+"update/partner/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable("id") Long id, @RequestBody PartnersReqDto partnersReqDto){
        ApiResponse update = partnersService.update(id, partnersReqDto);
        return ResponseEntity.ok(update);
    }




    @Tag(name = "Get partner to show partners -> ", description = "(It is accessible for all users)")
    @GetMapping(RestConstant.BASE_OPEN_APIS+"getPartner/{id}")
    public ResponseEntity<ApiResponse> getById(@PathVariable("id") Long id){

        ApiResponse byId = partnersService.getById(id);
        return ResponseEntity.ok(byId);
    }

    @Tag(name = "Get all partners -> ", description = "(It is accessible for all users)")
    @GetMapping(RestConstant.BASE_OPEN_APIS+"getAll/partners")
    public ResponseEntity<ApiResponse> getAll(){
        ApiResponse all = partnersService.getAll();
        return ResponseEntity.ok(all);
    }

    @Tag(name = "deleting partner -> ", description = "(It is accessible for admin)")
    @CheckRole({RolName.ADMIN})
    @DeleteMapping(RestConstant.BASE_SECURE_PATH+"delete/partner/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable("id") Long id){
        ApiResponse delete = partnersService.delete(id);
        return ResponseEntity.ok(delete);
    }

}
