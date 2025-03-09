package com.example.kursishi.service;

import com.example.kursishi.common.ApiResponse;
import com.example.kursishi.entity.Partners;
import com.example.kursishi.mapper.PartnersMapper;
import com.example.kursishi.repository.PartnersRepository;
import com.example.kursishi.request.PartnersReqDto;
import com.example.kursishi.request.PartnersResDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartnersService {
    private final PartnersMapper partnersMapper;
    private final PartnersRepository partnersRepository;

    public ApiResponse create(PartnersReqDto partnersReqDto){
        Partners partners = new Partners();
        partnersMapper.toPartners(partnersReqDto,partners);

        partnersRepository.save(partners);

        PartnersResDto partnersRes = partnersMapper.toPartnersRes(partners);
        return new ApiResponse("Partner create successfully",true,partnersRes);

    }

    public ApiResponse update(Long id,PartnersReqDto partnersReqDto){
        Partners partners = partnersRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("partner not found / update"));
        partnersMapper.toPartners(partnersReqDto,partners);
        partnersRepository.save(partners);

        PartnersResDto partnersRes = partnersMapper.toPartnersRes(partners);

        return new ApiResponse("partner update successfully",true,partnersRes);
    }

    public ApiResponse getById(Long id){

        Partners partners = partnersRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("partner not found / getById"));
        PartnersResDto partnersRes = partnersMapper.toPartnersRes(partners);
        return ApiResponse.builder().status(true).data(partnersRes).build();

    }

    public ApiResponse getAll(){
        List<PartnersResDto> list = partnersRepository.findAll().stream().map(partnersMapper::toPartnersRes).toList();

        return ApiResponse.builder().status(true).data(list).build();
    }

    public ApiResponse delete(Long id){
        Partners partners = partnersRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("partner not found / delete"));
        partnersRepository.delete(partners);

        return ApiResponse.builder().status(true).message("Deleted successfully").build();
    }



}
