package com.laceUp.LaceUp.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class jwtHandler {

    @Value("${jwt.secret}")
    private static String secret = "Secretss";

    public static String generateToken(String email, String userId, String type) {
        String token = Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("type", type)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

        return token;
    }

    public static Map<String, Object> validateToken(String token) {
        Map<String, Object> response = new HashMap<>();
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            response.put("email", body.getSubject());
            response.put("userId", body.get("userId"));
            response.put("type", body.get("type"));
            response.put("isValid", true);
        } catch (Exception e) {
            response.put("isValid", false);
        }
        return response;
    }

}
