package com.example.demo.modelMapper;

import com.example.demo.dto.NewsDTO;
import com.example.demo.entity.Category;
import com.example.demo.entity.News;

import java.util.stream.Collectors;

public class EntityToDTO {

    public static NewsDTO convertToDTO(News news) {

        NewsDTO dto = new NewsDTO();
        dto.setTitle(news.getTitle());
        dto.setContent(news.getContent());
        dto.setCategoryIds(news.getCategories().stream().map(Category::getId).collect(Collectors.toList()));
        return dto;
    }
}
