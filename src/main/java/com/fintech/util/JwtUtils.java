package com.fintech.util;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fintech.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {
	
	 private static final String str="ThisIsASecretKeyForJwtSigningThatShouldBeLongEnough123!";
	private final Key key=Keys.hmacShaKeyFor(str.getBytes());
	private static final long EXPIRATION_TIME_MS = 86400000;
	public String generateToken(User user) {
		return Jwts.builder()
				.setSubject(user.getEmail())
				.claim("id", user.getId())
				.claim("role", user.getRole())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME_MS))
				.signWith(key,SignatureAlgorithm.HS256)
				.compact();
	}
	public String extractName(String token) {
		
		return getClaims(token).getSubject();
	}
	
	 public boolean validateToken(String token) {
	        try {
	            getClaims(token);
	            return true;
	        } catch (JwtException | IllegalArgumentException e) {
	            return false;
	        }
	    }

	
	private Claims getClaims(String token) {
		   
		return Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(token)
				.getBody();
	}

}
