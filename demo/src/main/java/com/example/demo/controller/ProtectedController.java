package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProtectedController {

    @GetMapping("/protected")
    public ResponseEntity<String> protectedEndpoint(Authentication authentication) {
        return ResponseEntity.ok("你好，" + authentication.getName() + "！这是一个受保护的接口");
    }

    @GetMapping("/public")
    public ResponseEntity<String> publicEndpoint() {
        return ResponseEntity.ok("这是一个公开接口，无需认证");
    }
}