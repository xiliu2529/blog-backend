package com.example.demo.repository;

import com.example.demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

// 第一个参数是实体类，第二个参数是主键类型（id 是 Long）
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
