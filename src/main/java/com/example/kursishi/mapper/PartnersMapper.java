package com.example.kursishi.mapper;


import com.example.kursishi.entity.Attachment;
import com.example.kursishi.entity.Partners;
import com.example.kursishi.repository.AttachmentRepository;
import com.example.kursishi.request.PartnersReqDto;
import com.example.kursishi.request.PartnersResDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PartnersMapper {

    private final AttachmentRepository attachmentRepository;

    public void toPartners(PartnersReqDto partnersReqDto, Partners partners){

        partners.setNomi(partnersReqDto.name());
        partners.setDescription(partnersReqDto.description());

        partners.setImageUrl(partnersReqDto.imageUrl());

    }

    public PartnersResDto toPartnersRes(Partners partners )
    {
        return new PartnersResDto
                (
                        partners.getId(),
                        partners.getNomi(),
                        partners.getDescription(),
                        partners.getImageUrl()
                );
    }
}
