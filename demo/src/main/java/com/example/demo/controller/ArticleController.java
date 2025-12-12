package com.example.demo.controller;

import com.example.demo.dto.ArticleRequestDto;
import com.example.demo.entity.Article;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public ResponseEntity<List<Article>> getAllArticles() {
        return ResponseEntity.ok(articleService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getArticleById(@PathVariable Integer id) {
        Article article = articleService.getById(id);
        if (article == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(article);
    }

    // 🚀 创建文章（这里自动带 userId）
    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody ArticleRequestDto dto) {

        Integer userId = 1; // ⚠ 暂时写死，等你做登录后自动获取

        return ResponseEntity.ok(articleService.create(userId, dto));
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
