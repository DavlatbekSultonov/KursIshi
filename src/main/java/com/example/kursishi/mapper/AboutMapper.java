package com.example.kursishi.mapper;


import com.example.kursishi.entity.About;
import com.example.kursishi.repository.AboutRepository;
import com.example.kursishi.repository.AttachmentRepository;
import com.example.kursishi.request.AboutReqDto;
import com.example.kursishi.request.AboutResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AboutMapper {
    private final AboutRepository aboutRepository;
    private final AttachmentRepository attachmentRepository;

    public void toAbout(AboutReqDto aboutReqDto, About about){
        about.setDescription(aboutReqDto.description());
        about.setTelegram(aboutReqDto.telegramBot());
        about.setName(aboutReqDto.name());
        about.setPhoneNumber(aboutReqDto.phoneNumber());
        about.setImageUrl(aboutReqDto.imageUrl());
    }

    public AboutResDto toResponse(About about){
        return new AboutResDto(
                about.getName(),
                about.getDescription(),
                about.getPhoneNumber(),
                about.getTelegram(),
                about.getImageUrl()
        );
    }

}
