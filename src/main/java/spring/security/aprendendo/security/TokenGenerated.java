package spring.security.aprendendo.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import spring.security.aprendendo.models.Login;

@Service
public class TokenGenerated {

    @Value("${api.security.token.secret}")
    private String key;

    public String gerarToken(Login email) { 
        try {
            var algoritmo = Algorithm.HMAC256(key);

            return JWT.create()
                .withIssuer("API aprendendo")
                .withSubject(email.getEmail())
                .withExpiresAt(dataExpiracao())
                .sign(algoritmo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("erro ao gerrar token jwt", exception);
        }		
    }

    private Instant dataExpiracao(){
        return LocalDateTime.now().plusMinutes(15).toInstant(ZoneOffset.of("-03:00"));
    }
}
