package kr.codesquad.baseball.common.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import kr.codesquad.baseball.common.error.exception.LoginRequiredException;
import kr.codesquad.baseball.web.view.UserView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Service
public class JwtService {

    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final String USER_JWT_KEY = "user";

    public String createJws(String jwtKey, Object data) {
        Map<String, Object> headers = new HashMap<>();
        headers.put("typ", "JWT");
        headers.put("alg", "HS256");

        Map<String, Object> payloads = new HashMap<>();
        payloads.put(jwtKey, data);

        return Jwts.builder()
                   .setHeader(headers)
                   .setClaims(payloads)
                   .signWith(key)
                   .compact();
    }

    public String createJws(Map<String, Object> payloads) {
        Map<String, Object> headers = new HashMap<>();
        headers.put("typ", "JWT");
        headers.put("alg", "HS256");

        return Jwts.builder()
                   .setHeader(headers)
                   .setClaims(payloads)
                   .signWith(key)
                   .compact();
    }

    public String createUserJws(UserView data) {
        Map<String, Object> headers = new HashMap<>();
        headers.put("typ", "JWT");
        headers.put("alg", "HS256");

        Map<String, UserView> payloads = new HashMap<>();
        payloads.put(USER_JWT_KEY, data);

        return Jwts.builder()
                   .setHeader(headers)
                   .setClaims(payloads)
                   .signWith(key)
                   .compact();
    }

    public Map<String, Object> getDataFromJws(String jwtKey, String jws) {
        Jws<Claims> claims;
        try {
            claims = Jwts.parserBuilder()
                         .setSigningKey(key)
                         .build()
                         .parseClaimsJws(jws);
            return (LinkedHashMap<String, Object>) claims.getBody().get(jwtKey);
        } catch (JwtException ex) {
            log.error("인증되지 않은 jwt token입니다. jws: {}", jws);
            // Custom Exception Unauthorized Exception
            throw new LoginRequiredException("인증되지 않은 jwt token입니다.");
        }
    }

    public UserView getUserFromJws(String jws) {
        Jws<Claims> claims;
        try {
            claims = Jwts.parserBuilder()
                         .setSigningKey(key)
                         .build()
                         .parseClaimsJws(jws);
            return UserView.of((LinkedHashMap<String, String>) claims.getBody().get(USER_JWT_KEY));
        } catch (JwtException ex) {
            log.error("인증되지 않은 jwt token입니다. jws: {}", jws);
            // Custom Exception Unauthorized Exception
            throw new LoginRequiredException("인증되지 않은 jwt token입니다.");
        }
    }
}
