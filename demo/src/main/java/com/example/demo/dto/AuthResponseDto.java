package com.example.demo.dto;

import lombok.Data;

@Data
public class AuthResponseDto {
    private String token;
    private String refreshToken;
    private String type = "Bearer";
    private Long userId;
    private String username;
    
    public AuthResponseDto(String token, Long userId, String username) {
        this.token = token;
        this.userId = userId;
        this.username = username;
    }
    
    public AuthResponseDto(String token, String refreshToken, Long userId, String username) {
        this.token = token;
        this.refreshToken = refreshToken;
        this.userId = userId;
        this.username = username;
    }
}