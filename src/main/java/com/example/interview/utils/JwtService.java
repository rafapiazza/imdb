package com.example.interview.utils;

import com.example.interview.models.entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JwtService {

    @Value("${security.jwt.expiration}")
    private String expiration;

    @Value("${security.jwt.key}")
    private String key;

    public String generateToken(User user){
        long expString = Long.valueOf(expiration);
        LocalDateTime dataHoraExpiration = LocalDateTime.now().plusMinutes(expString);
        Instant instant = dataHoraExpiration.atZone(ZoneId.systemDefault()).toInstant();
        Date data = Date.from(instant);

        return Jwts
                .builder()
                .setSubject(user.getUsername())
                .setExpiration(data)
                .signWith( SignatureAlgorithm.HS512, key)
                .compact();
    }

    private Claims obtainClaims(String token ) throws ExpiredJwtException {
        return Jwts
                .parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean tokenValid(String token ){
        try{
            Claims claims = obtainClaims(token);
            Date dataExpiration = claims.getExpiration();
            LocalDateTime data =
                    dataExpiration.toInstant()
                            .atZone(ZoneId.systemDefault()).toLocalDateTime();
            return !LocalDateTime.now().isAfter(data);
        }catch (Exception e){
            return false;
        }
    }

    public String obtainLoginUser(String token) throws ExpiredJwtException{
        return (String) obtainClaims(token).getSubject();
    }
}
