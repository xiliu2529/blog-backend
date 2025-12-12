package com.example.demo.service;

import com.example.demo.entity.Article;
import com.example.demo.dto.ArticleRequestDto;
import com.example.demo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    public Article getById(Integer id) {
        return articleRepository.findById(id).orElse(null);
    }

    // 🚀 创建文章核心方法
    public Article create(Integer userId, ArticleRequestDto dto) {
        Article article = new Article();
        article.setUserId(userId);
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
        article.setCategoryId(dto.getCategoryId());
        article.setCreatedAt(LocalDateTime.now());
        article.setUpdatedAt(LocalDateTime.now());

        return articleRepository.save(article);
    }

    public Article update(Integer id, ArticleRequestDto dto) {
        Article article = articleRepository.findById(id).orElse(null);
        if (article == null)
            return null;

        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
        article.setCategoryId(dto.getCategoryId());
        article.setUpdatedAt(LocalDateTime.now());

        return articleRepository.save(article);
    }

    public void delete(Integer id) {
        articleRepository.deleteById(id);
    }
}
