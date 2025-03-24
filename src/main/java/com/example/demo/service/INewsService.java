package com.example.demo.service;

import com.example.demo.dto.NewsDTO;
import com.example.demo.entity.News;

import java.util.List;
import java.util.Optional;

public interface INewsService {
    List<News> getNewsByCategory(String categoryName);
    Optional<News> getNewsById(Long id);

    NewsDTO saveNews(NewsDTO newsDTO);

    List<String> getAllHeadlines();

}

