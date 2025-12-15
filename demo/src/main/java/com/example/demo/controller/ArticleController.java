package com.example.demo.controller;

import com.example.demo.dto.ArticleRequestDto;
import com.example.demo.entity.Article;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    // 🚀 创建文章（这里自动带 userId） // 🚀 创建文章
    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody ArticleRequestDto dto) {

        Integer userId = 1; // TODO: 从登录信息中获取

        Article article = articleService.create(userId, dto);

        return ResponseEntity.status(201).body(article);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateArticle(
            @PathVariable Integer id,
            @RequestBody ArticleRequestDto dto) {
        Article updated = articleService.update(id, dto);
        if (updated == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable Integer id) {
        articleService.delete(id);
        return ResponseEntity.ok().build();
    }

}
