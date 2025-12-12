package com.example.demo.dto;

import lombok.Data;

@Data
public class ArticleRequestDto {
    private String title;
    private String content;
    private Integer categoryId;
}
