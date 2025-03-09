package com.example.kursishi.controller;

import com.example.kursishi.common.ApiResponse;
import com.example.kursishi.request.PartnersReqDto;
import com.example.kursishi.service.PartnersService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/partners")
public class PartnerController {
    private final PartnersService partnersService;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> create(@RequestBody PartnersReqDto partnersReqDto){
        ApiResponse apiResponse = partnersService.create(partnersReqDto);
        return ResponseEntity.ok(apiResponse);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable Long id, @RequestBody PartnersReqDto partnersReqDto){
        ApiResponse update = partnersService.update(id, partnersReqDto);
        return ResponseEntity.ok(update);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ApiResponse> getById(@PathVariable Long id){

        ApiResponse byId = partnersService.getById(id);
        return ResponseEntity.ok(byId);
    }

    @GetMapping("/getAll")
    public ResponseEntity<ApiResponse> getAll(){
        ApiResponse all = partnersService.getAll();
        return ResponseEntity.ok(all);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id){
        ApiResponse delete = partnersService.delete(id);
        return ResponseEntity.ok(delete);
    }

}
