package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {

    private final String secretKey = "amypo_secret_key_123";
    private final long validityInMillis = 60 * 60 * 1000; // 1 hour

    // 🔐 Generate JWT token
    public String generateToken(String email, String role, Long userId) {

        Claims claims = Jwts.claims().setSubject(email);
        claims.put("role", role);
        claims.put("userId", userId);

        Date now = new Date();
        Date expiry = new Date(now.getTime() + validityInMillis);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // 🔍 Validate token
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 📧 Extract email from token
    public String extractEmail(String token) {
        return getClaims(token).getSubject();
    }

    // 🧑‍💼 Extract role from token
    public String extractRole(String token) {
        return getClaims(token).get("role", String.class);
    }

    // 🆔 Extract userId from token
    public Long extractUserId(String token) {
        return getClaims(token).get("userId", Long.class);
    }

    // 🔧 Helper method
    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }
}
