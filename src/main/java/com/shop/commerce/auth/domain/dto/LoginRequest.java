package com.shop.commerce.auth.domain.dto;

import lombok.Getter;

@Getter
public class LoginRequest {
    private String username;
    private String password;
}
