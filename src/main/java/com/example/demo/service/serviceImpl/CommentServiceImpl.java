package com.example.demo.service.serviceImpl;

import com.example.demo.entity.Comment;
import com.example.demo.entity.News;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.NewsRepository;
import com.example.demo.service.ICommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {

    private final NewsRepository newsRepository;
    private final CommentRepository commentRepository;

    public CommentServiceImpl(NewsRepository newsRepository, CommentRepository commentRepository) {
        this.newsRepository = newsRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment addComment(Long newsId, Comment comment) {

        News news = newsRepository.findById(newsId)
                .orElseThrow(() -> new RuntimeException("News not found with ID: " + newsId));

        comment.setNews(news);
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getCommentsByNewsId(Long newsId) {
        return null;
    }
}
