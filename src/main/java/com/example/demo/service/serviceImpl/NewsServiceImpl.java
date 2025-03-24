package com.example.demo.service.serviceImpl;

import com.example.demo.dto.NewsDTO;
import com.example.demo.entity.Category;
import com.example.demo.entity.News;
import com.example.demo.exception.CategoryNotFoundException;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.NewsRepository;
import com.example.demo.service.INewsService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.demo.modelMapper.EntityToDTO.convertToDTO;

@Service
public class NewsServiceImpl implements INewsService {

    private final NewsRepository newsRepository;
    private final CategoryRepository categoryRepository;

    public NewsServiceImpl(NewsRepository newsRepository, CategoryRepository categoryRepository) {
        this.newsRepository = newsRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    public List<News> getNewsByCategory(String categoryName) {
        return newsRepository.findByCategoriesName(categoryName);
    }

    public Optional<News> getNewsById(Long id) {
        return newsRepository.findById(id);
    }

    public News saveNews(News news) {
        return newsRepository.save(news);
    }


    @Override
    public NewsDTO saveNews(NewsDTO newsDTO) {
        try {
            News news = new News();
            news.setTitle(newsDTO.getTitle());
            news.setContent(newsDTO.getContent());

            List<Category> categories = categoryRepository.findAllById(newsDTO.getCategoryIds());

            if (categories.isEmpty()) {
                throw new CategoryNotFoundException("No categories found for the given IDs: " + newsDTO.getCategoryIds());
            }

            news.setCategories(new HashSet<>(categories));
            News savedNews = newsRepository.save(news);

            return convertToDTO(savedNews);
        } catch (CategoryNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error while saving news", e);
        }
    }


    public List<String> getAllHeadlines() {
        return newsRepository.findAll().stream()
                .map(News::getTitle)
                .collect(Collectors.toList());
    }
}
