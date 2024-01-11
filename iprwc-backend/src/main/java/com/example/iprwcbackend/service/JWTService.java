package com.example.iprwcbackend.service;

import com.example.iprwcbackend.model.User;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

@Service
public class JWTService {
    private final String SECRET_KEY = "secret";
    private final int EXPIRATION_DURATION = 1000 * 60 * 60 * 10;

    public String generateToken(User userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", userDetails.getRole());
        return createToken(claims, userDetails);
    }

    private String createToken(Map<String, Object> claims, User userDetails) {

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .claim("userID", userDetails.getId())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_DURATION))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException ex) {
            System.err.println("JWT expired" + ex.getMessage());
        } catch (IllegalArgumentException ex) {

        } catch (MalformedJwtException ex) {
            System.err.println("JWT is invalid" + ex);
        } catch (UnsupportedJwtException ex) {
            System.err.println("JWT is not supported" + ex);
        } catch (SignatureException ex) {
            System.err.println("Signature validation failed");
        }
        return false;
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    public String extractRoles(String token) {
        return String.valueOf(extractAllClaims(token).get("roles"));
    }

    public UUID extractID(String token) {
        return UUID.fromString(String.valueOf(extractAllClaims(token).get("userID")));
    }

    public int getEXPIRATION_DURATION(){
        return this.EXPIRATION_DURATION;
    }
}
