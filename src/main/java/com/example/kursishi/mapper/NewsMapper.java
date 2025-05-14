package com.example.kursishi.mapper;

import com.example.kursishi.entity.News;
import com.example.kursishi.request.NewsReqDto;
import com.example.kursishi.request.NewsResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class NewsMapper {

    public void ToNews(NewsReqDto newsReqDto, News news){
        news.setTitle(newsReqDto.title());
        news.setDescription(newsReqDto.description());
        news.setImageUrl(newsReqDto.imageUrl());
        news.setCreateTime(LocalDateTime.now());
    }

    public NewsResDto ResponseDto(News news){
        return new NewsResDto(
                news.getId(),
                news.getTitle(),
                news.getDescription(),
                news.getImageUrl(),
                news.getCreateTime()
        );
    }
}
