package com.example.kursishi.service;

import com.example.kursishi.common.ApiResponse;
import com.example.kursishi.entity.News;
import com.example.kursishi.mapper.NewsMapper;
import com.example.kursishi.repository.NewsRepository;
import com.example.kursishi.request.NewsReqDto;
import com.example.kursishi.request.NewsResDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsMapper newsMapper;
    private final NewsRepository newsRepository;


    public ApiResponse create(NewsReqDto newsReqDto) {
        News news = new News();
        newsMapper.ToNews(newsReqDto, news);
        newsRepository.save(news);

        NewsResDto newsResDto = newsMapper.ResponseDto(news);

        return ApiResponse.builder().message("News Successfully").status(true).data(newsResDto).build();
    }

    public ApiResponse update(NewsReqDto newsReqDto, Long id) {
        News news = newsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        newsMapper.ToNews(newsReqDto, news);
        newsRepository.save(news);

        NewsResDto newsResDto = newsMapper.ResponseDto(news);
        return ApiResponse.builder().message("News Edited").status(true).data(newsResDto).build();
    }

    public ApiResponse getById(Long id) {
        News news = newsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        NewsResDto newsResDto = newsMapper.ResponseDto(news);
        return ApiResponse.builder().status(true).data(newsResDto).build();
    }

    public ApiResponse getAll() {
        List<NewsResDto> list = newsRepository.findAll().stream().map(newsMapper::ResponseDto).toList();
        return ApiResponse.builder().status(true).data(list).build();
    }

    public ApiResponse delete(Long id) {
        News news = newsRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        newsRepository.delete(news);
        return ApiResponse.builder().status(true).message("Deleted").data(news).build();
    }
}
