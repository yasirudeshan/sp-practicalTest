package com.example.demo.controller;

import com.example.demo.dto.NewsDTO;
import com.example.demo.entity.News;
import com.example.demo.service.INewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    private final INewsService newsService;

    public NewsController(INewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/category/{name}")
    public List<News> getNewsByCategory(@PathVariable String name) {
        return newsService.getNewsByCategory(name);
    }

    @GetMapping("/{id}")
    public ResponseEntity<News> getNewsById(@PathVariable Long id) {
        Optional<News> news = newsService.getNewsById(id);
        return news.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<NewsDTO> createNews(@RequestBody NewsDTO newsDTO) {
        NewsDTO savedNews = newsService.saveNews(newsDTO);
        return ResponseEntity.ok(savedNews);
    }

    @GetMapping("/headlines")
    public ResponseEntity<List<String>> getNewsHeadlines() {
        List<String> headlines = newsService.getAllHeadlines();
        return ResponseEntity.ok(headlines);
    }

}
