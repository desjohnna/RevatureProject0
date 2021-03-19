package dev.gray.token;

import io.javalin.http.ForbiddenResponse;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class Token implements TokenManager {

    private final Key key;

    public Token() {
        this.key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    @Override
    public String issueToken(String userId) {
        return Jwts.builder().setSubject(userId).signWith(key).compact();
    }

    @Override
    public boolean authorize(String token, String userId) {
        try {
            String subject = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
            return subject.equalsIgnoreCase(userId);
        } catch (Exception ex){
            throw new ForbiddenResponse();
        }
    }

}
