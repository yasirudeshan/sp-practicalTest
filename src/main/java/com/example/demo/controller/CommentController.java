package com.example.demo.controller;

import com.example.demo.entity.Comment;
import com.example.demo.service.ICommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final ICommentService commentService;

    public CommentController(ICommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping(value = "/{newsId}", consumes = "application/json")
    public ResponseEntity<Comment> addComment(@PathVariable Long newsId, @RequestBody Comment comment) {
        Comment savedComment = commentService.addComment(newsId, comment);
        return ResponseEntity.ok(savedComment);
    }

    @GetMapping("/{newsId}")
    public List<Comment> getCommentsByNews(@PathVariable Long newsId) {
        return commentService.getCommentsByNewsId(newsId);
    }
}
