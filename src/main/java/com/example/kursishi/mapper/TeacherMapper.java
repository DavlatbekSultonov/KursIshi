package com.example.kursishi.mapper;

import com.example.kursishi.entity.Teacher;
import com.example.kursishi.repository.AttachmentRepository;
import com.example.kursishi.request.TeacherReqDto;
import com.example.kursishi.request.TeacherResDto;
import com.example.kursishi.service.AttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class TeacherMapper {
    private final AttachmentRepository attachmentRepository;
    private final AttachmentService attachmentService;

    public void ToTeacher(Teacher teacher, TeacherReqDto reqDto){

        teacher.setName(reqDto.name());
        teacher.setSurname(reqDto.surname());
        teacher.setPhoneNumber(reqDto.phoneNumber());
        teacher.setArticleLink(reqDto.articleLink());
        teacher.setDescription(reqDto.description());
        teacher.setTelegramLink(reqDto.telegramLink());
        teacher.setImageUrl(reqDto.imageUrl());
        teacher.setPosition(reqDto.position());
        teacher.setCreatedAt(LocalDateTime.now());
        teacher.setLastUpdatedDate(LocalDateTime.now());
        teacher.setDeleted(false);
    }

    public TeacherResDto toResTeacher(Teacher teacher){
        return new TeacherResDto(
                teacher.getId(),
                teacher.getName(),
                teacher.getSurname(),
                teacher.getPhoneNumber(),
                teacher.getPosition(),
                teacher.getTelegramLink(),
                teacher.getArticleLink(),
                teacher.getDescription(),
                teacher.getImageUrl()

        );
    }
    private String getImageUrl(Teacher teacher) {
        if (teacher.getImageUrl() != null) {
            return attachmentService.getImageUrl(teacher.getImageUrl());
        }
        return attachmentService.getImageUrl("no-image.png"); // Default rasm


    }


}

