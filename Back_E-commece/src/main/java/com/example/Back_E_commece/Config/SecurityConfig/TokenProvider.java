package com.example.Back_E_commece.Config.SecurityConfig;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class TokenProvider {

    @Value("${api.security.token.expiration}")
    private long expirationTime;

    @Value("${api.security.token.secret}")
    private String Key;

    public String GeraToken( Authentication authentication)
    { // To pegando os dados do usuario de forma detalhada e passando somente o emial para o meu metodo que constroi a chave
        UserDetails user = (UserDetails) authentication.getPrincipal();
        return buildToken(user.getUsername());
    }

    private   String buildToken(String username){ //Aqui eu construo o token com base nos dados do usuario como email+tempo de expiração.
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationTime);



        return Jwts.builder()
                .subject(username)
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(getSigningKey())
                .compact();
    }

    private SecretKey  getSigningKey()
    {
        return Keys.hmacShaKeyFor(Key.getBytes());// Pego a chave que é uma string e transforma em bytes pra depois pega os bytes e transforma em HMAC-SHA
    }
    public boolean isTokenValid(String token) { //Valida o tokenJWT
        try{
        getClaims(token);
        return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    private Claims getClaims(String token)//Verifica a minha chave pra ver se não é falsa
    {
        return Jwts
                .parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }


    public String getUsername(String token){ //Aqui pega o token e passa para a classe getClaims para que ela indetifique se o token é verdadeiro ou não 
        return getClaims(token).getSubject();
    }

}
