package com.momoon.board.token;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Calendar;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private final long tokenValidityInSecond;

    private final long refreshValidityDay;

    private Key key;

    private Key refreshKey;

    public JwtTokenProvider(
            @Value("${jwt.token-validity-in-second}") long tokenValidityInSecond,
            @Value("${jwt.refresh-validity-day}") long refreshValidityDay,
            @Value("${jwt.key}") String key,
            @Value("${jwt.refresh-key}") String refreshKey) {

        this.tokenValidityInSecond = tokenValidityInSecond * 1000;
        this.refreshValidityDay = refreshValidityDay * 1000 * 60 * 60 * 24;
        this.key = Keys.hmacShaKeyFor(key.getBytes());
        this.refreshKey = Keys.hmacShaKeyFor(refreshKey.getBytes());
    }

    public String createToken(String memberId) {

        long now = new Date().getTime();

        return Jwts.builder()
                .subject("board")
                .claim("memberId", memberId)
                .signWith(key)
                .expiration(new Date(now + tokenValidityInSecond))
                .compact();
    }

    public String createRefreshToken(String memberId) {

        long now = new Date().getTime();

        return Jwts.builder()
                .subject("board-refresh")
                .claim("memberId", memberId)
                .issuedAt(new Date())
                .expiration(new Date(now + refreshValidityDay))
                .signWith(refreshKey)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith((SecretKey) key)
                    .build().parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
