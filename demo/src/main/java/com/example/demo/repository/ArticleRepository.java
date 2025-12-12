package com.example.demo.repository;

import com.example.demo.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    // 如果以后需要根据用户查看文章：
    List<Article> findByUserId(Integer userId);
}
