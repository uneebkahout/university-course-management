package com.example.ucms.security;

import com.example.ucms.entity.Users;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class AuthUtil {
    @Value("${jwt.secretKey}")
private  String jwtSecretKey;

    private SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
    }

    public  String generateAccessToken(Users user){
        return Jwts.builder().subject(user.getUsername())
                .claim("userId", user.getUser_id())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+ 1000*60*10)).compact();
    }
}
