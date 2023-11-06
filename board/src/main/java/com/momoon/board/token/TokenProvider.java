package com.momoon.board.token;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.momoon.board.member.domain.Member;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ClaimsBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.servlet.http.Cookie;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class TokenProvider {

    private final int accessValiditySecond;
    private final int refreshValidityDay;
    private Key key;
    private Key refreshKey;


    public TokenProvider(
            @Value("${jwt.token-validity-in-second}") int accessValiditySecond,
            @Value("${jwt.refresh-validity-in-day}") int refreshValidityDay,
            @Value("${jwt.secret-key}") String key,
            @Value("${jwt.refresh-key}") String refreshKey
    ) {
        this.accessValiditySecond = accessValiditySecond * 1000;
        this.refreshValidityDay = refreshValidityDay * 60 * 60 * 24 * 1000;
        this.key = Keys.hmacShaKeyFor(key.getBytes());
        this.refreshKey = Keys.hmacShaKeyFor(refreshKey.getBytes());
    }


    public String createAccessToken(String loginId) {

        Date validDate = new Date(System.currentTimeMillis() + accessValiditySecond);

        return Jwts.builder()
                .subject("board")
                .claim("username", loginId)
                .issuedAt(new Date())
                .expiration(validDate)
                .signWith(key)
                .compact();
    }

    public String createRefreshToken(String loginId) {
        Date validDate = new Date(System.currentTimeMillis() + refreshValidityDay);

        return Jwts.builder()
                .subject("board-refresh")
                .claim("username", loginId)
                .issuedAt(new Date())
                .expiration(validDate)
                .signWith(refreshKey)
                .compact();
    }

    public Cookie createRefreshCookie(String refresh) {
        Cookie cookie = new Cookie("refresh", refresh);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(refreshValidityDay);

        return cookie;
    }
}
