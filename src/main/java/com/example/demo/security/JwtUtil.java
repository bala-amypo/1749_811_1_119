package com.example.demo.security;

import com.example.demo.model.User;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class JwtUtil {

    private final String secret = "secretkey123456";

    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("role", user.getRole())
                .claim("userId", user.getId())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String extractEmail(String token) {
        return getClaims(token).getSubject();
    }

    public Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
}
