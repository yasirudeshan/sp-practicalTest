package com.example.demo.service;

import com.example.demo.entity.Comment;

import java.util.List;

public interface ICommentService {
    Comment addComment(Long newsId, Comment comment);
    List<Comment> getCommentsByNewsId(Long newsId);
}
