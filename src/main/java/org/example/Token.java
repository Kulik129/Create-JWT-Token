package org.example;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class Token {
    private static final String KEY = "53A73E5F1C4E0A2D3B5F2D784E6A1B423D6F247D1F6E5C3A596D635A75327855";

    public static String generateToken(String subject, User user, int tokenValidationDays) {
        long expirationTimeInMilliseconds = tokenValidationDays * 24 * 60 * 60 * 1000L;

        Date now = new Date();
        Date experationDate = new Date(now.getTime() + expirationTimeInMilliseconds);

        return Jwts.builder()
                .setSubject(subject)
                .claim("userID", user.getId())
                .claim("userRole", user.getUserRole())
                .claim("userName", user.getName())
                .setIssuedAt(now)
                .setExpiration(experationDate)
                .signWith(SignatureAlgorithm.HS256, KEY)
                .compact();
    }

    public static long getRemainingTime(String jwtToken) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(jwtToken)
                .getBody();

        Date experationDate = claims.getExpiration();
        Date now = new Date();

        return experationDate.getTime() - now.getTime();
    }
}
