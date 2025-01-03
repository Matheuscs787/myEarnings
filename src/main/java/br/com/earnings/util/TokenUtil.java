package br.com.earnings.util;

import br.com.earnings.dto.LoginDTO;
import br.com.earnings.security.Token;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Collections;
import java.util.Date;

public class TokenUtil {

    public final static String EMISSOR = "EMISSOR";
    public final static Long EXPIRATION = 2*60*1000L;
    public final static String SECRET_KEY = "01234567890123456789012345678912"; //precisa de pelo menos 32 caracteres

    public static Token encode(LoginDTO dadosLogin){

        try{
            Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
            String jwtToken = Jwts.builder()
                    .subject(dadosLogin.username())
                    .issuer(EMISSOR)
                    .expiration(new Date(System.currentTimeMillis() + EXPIRATION))
                    .signWith(key)
                    .compact();

            return new Token(jwtToken);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static Authentication decode(HttpServletRequest request){

        try{
            String token = request.getHeader("Authorization");
            if(token != null){
                token = token.replace("Bearer ", "");
                SecretKey secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
                JwtParser parser = Jwts.parser().verifyWith(secretKey).build();
                Claims claims = (Claims) parser.parse(token).getPayload();

                String subject = claims.getSubject();
                String issuer = claims.getIssuer();
                Date expiration = claims.getExpiration();

                if(issuer.equals(EMISSOR) && !subject.isEmpty() && expiration.after(new Date(System.currentTimeMillis()))) {
                    Authentication auth = new UsernamePasswordAuthenticationToken("usuario", null, Collections.emptyList());
                    return auth;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
