package com.example.demo.tokenService;

import com.example.demo.model.Token;
import com.example.demo.repository.TokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class TokenService {
    @Autowired
    private TokenRepo tokenRepo;

    public Token findTokenByName(String token) {
        return tokenRepo.findTokenByName(token);
    }

    public boolean checkValidToken(String token) {
        if (findTokenByName(token) == null) return false;
        return true;
    }

    public void delete(String token) {
        tokenRepo.delete(findTokenByName(token));
    }

    public Token save(Token token) {
        return tokenRepo.save(token);
    }

    public String getJwtFromRequest(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.replace("Bearer ", "");
        }

        return null;
    }
}
