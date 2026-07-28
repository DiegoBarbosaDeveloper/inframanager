package com.diegodev.inframanager.security.infrastructure.adapter.out;

import com.diegodev.inframanager.security.domain.port.out.TokenProviderPort;
import com.diegodev.inframanager.user.domain.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.util.Date;

@Component
public class JwtTokenProviderAdapter implements TokenProviderPort {

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    @Value("${jwt.exp}")
    private long EXP_TIME;

    @Override
    public String generateToken(User user) {
        Instant time = Instant.now();
        return Jwts.builder()
                .subject(user.getEmail())
                .claim("Role", user.getRole().name())
                .issuedAt(Date.from(time))
                .expiration(Date.from(time.plusMillis(EXP_TIME)))
                .signWith(getKey())
                .compact();
    }

    @Override
    public String getEmail(String token) {
        return parseClaims(token).getSubject();
    }

    @Override
    public boolean isValid(String token) {
        try {
            parseClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException ex){
            return false;
        }
    }

    private Claims parseClaims(String token){
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getKey(){
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }
}
