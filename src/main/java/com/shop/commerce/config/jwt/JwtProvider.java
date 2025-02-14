package com.shop.commerce.config.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtProvider {
    private final String SECRET_KEY = "your-very-secure-secret-key-that-is-long-enough-for-hs512-algorithm-1234567890"; // 충분한 길이의 문자열을 사용해야한다.
    private final long EXPIRATION_TIME = 1000L * 60 * 60 * 24;
    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

    public String generateToken(Authentication authentication) {
        if (authentication == null || authentication.getAuthorities() == null) {
            throw new IllegalArgumentException("Authentication 정보가 올바르지 않습니다.");
        }

        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        long now = System.currentTimeMillis();
        Date validity = new Date(now + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(authentication.getName()) // 사용자 ID
                .claim("roles", authorities) // 권한 정보 추가
                .setIssuedAt(new Date(now)) // 토큰 발행 시간
                .setExpiration(validity) // 토큰 만료 시간
                .signWith(key, SignatureAlgorithm.HS512) // 서명(Signature) 추가
                .compact();
    }
}
