package com.example.demo.dto;

public class CommentDTO {
    private Long id;
    private String content;
    private String author;
    private Long newsId;


    public CommentDTO() {}

    public CommentDTO(Long id, String content, String author, Long newsId) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.newsId = newsId;
    }


}
