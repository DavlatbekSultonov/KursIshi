package com.example.kursishi.service;

import com.example.kursishi.common.ApiResponse;
import com.example.kursishi.entity.About;
import com.example.kursishi.mapper.AboutMapper;
import com.example.kursishi.repository.AboutRepository;
import com.example.kursishi.request.AboutReqDto;
import com.example.kursishi.request.AboutResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AboutService {
    private final AboutMapper aboutMapper;
    private final AboutRepository aboutRepository;

    // GET ALL
    public ApiResponse getAll() {
        List<About> aboutList = aboutRepository.findAll();
        List<AboutResDto> responseList = aboutList.stream()
                .map(aboutMapper::toResponse)
                .collect(Collectors.toList());

        return new ApiResponse("All About records fetched successfully", true, responseList);
    }
    // UPDATE
    public ApiResponse update(Long id, AboutReqDto aboutReqDto) {
        Optional<About> optionalAbout = aboutRepository.findById(id);
        if (optionalAbout.isEmpty()) {
            return new ApiResponse("About not found", false, null);
        }

        About about = optionalAbout.get();
        aboutMapper.toAbout(aboutReqDto, about);
        aboutRepository.save(about);

        AboutResDto response = aboutMapper.toResponse(about);
        return new ApiResponse("About updated successfully", true, response);
    }
}
