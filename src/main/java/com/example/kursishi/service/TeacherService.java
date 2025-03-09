package com.example.kursishi.service;


import com.example.kursishi.common.ApiResponse;
import com.example.kursishi.entity.Teacher;
import com.example.kursishi.mapper.TeacherMapper;
import com.example.kursishi.repository.TeacherRepository;
import com.example.kursishi.request.TeacherReqDto;
import com.example.kursishi.request.TeacherResDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherMapper teacherMapper;
    private final TeacherRepository teacherRepository;

    public ApiResponse create(TeacherReqDto teacherReqDto){

        Teacher teacher = new Teacher();

        teacherMapper.ToTeacher(teacher,teacherReqDto);
        teacherRepository.save(teacher);

        TeacherResDto resTeacher = teacherMapper.toResTeacher(teacher);

        return new ApiResponse(
                "Teacher Successfully",
                true,
                resTeacher
        );
    }

    public ApiResponse update(Long id,TeacherReqDto teacherReqDto){
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        teacherMapper.ToTeacher(teacher,teacherReqDto);
        teacherRepository.save(teacher);

        TeacherResDto resTeacher = teacherMapper.toResTeacher(teacher);

        return new ApiResponse
                (
                        "update teacher successfully",
                        true,
                        resTeacher
                );
    }

    public ApiResponse getId(Long id){
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        TeacherResDto resTeacher = teacherMapper.toResTeacher(teacher);
        return new ApiResponse
                (
                        "get by id teacher",
                        true,
                        resTeacher
                );

    }

    public ApiResponse getAll(){
        List<TeacherResDto> list = teacherRepository.findAll().stream().map(teacherMapper::toResTeacher).toList();

        return ApiResponse.builder().message("get all teachers").status(true).data(list).build();

    }

    public ApiResponse delete(Long id){
        Teacher teacher = teacherRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found"));

        teacherRepository.delete(teacher);

        return ApiResponse.builder().message("deleted successfully").status(true).data(teacher).build();
    }
}
