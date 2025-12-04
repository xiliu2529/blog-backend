package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/test-db")
    public String testDatabaseConnection() {
        try {
            // 测试数据库连接
            List<Map<String, Object>> result = jdbcTemplate.queryForList("SELECT version() as version");
            return "数据库连接成功！PostgreSQL版本: " + result.get(0).get("version");
        } catch (Exception e) {
            return "数据库连接失败: " + e.getMessage();
        }
    }
}