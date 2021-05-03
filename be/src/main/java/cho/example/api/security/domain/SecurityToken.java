package cho.example.api.security.domain;


import io.jsonwebtoken.*;
import lombok.extern.java.Log;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Log
public class SecurityToken {
    private final String token;
    private final String key;
    private int tokenExpirationMsec =1800000;
    private static final String AUTHORITIES_KEY = "role";

    public SecurityToken(String token, String key) {
        this.token = createToken();
        this.key = key;
    }

    public String createToken(){
        try{
            Map<String ,Object> headers = new HashMap<>();
            headers.put("alg","HS256");
            headers.put("typ","JWT");
            Map<String,Object> payloads = new HashMap<>();
            payloads.put("data","My First JWT Dummy");
            long expirationTime = 1000*60L *60L*2L; //2시간
            Date ext = new Date();
            ext.setTime(ext.getTime()+expirationTime);
            return Jwts
                    .builder()
                    .setHeader(headers)
                    .setClaims(payloads)
                    .setSubject("user")
                    .setExpiration(ext)
                    .signWith(SignatureAlgorithm.ES256, key.getBytes())
                    .compact();
        }catch (SecurityException e){
            log.info("Invalid JWT Signature");
        }catch (MalformedJwtException e){
            log.info("Invalid JWT token");
        }catch (ExpiredJwtException e){
            log.info("Expiration JWT token");
        }catch (UnsupportedJwtException e){
            log.info("Unsupported JWT Signature");
        }catch (IllegalArgumentException e){
            log.info("JWT token compact of handler are invalid");
        }
        return null;

    }
}
