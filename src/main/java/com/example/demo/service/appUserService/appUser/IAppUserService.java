package com.example.demo.service.appUserService.appUser;

import com.example.demo.model.LoginUser;
import com.example.demo.service.jwtService.JwtService;

import java.util.Optional;

public interface IAppUserService {
    LoginUser getUserByUserName(String username);
    LoginUser getCurrentUser();
    Optional<LoginUser> findByUsername(String username);
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
    LoginUser getUserCurrent(JwtService jwtService, String token);
    LoginUser findAppUserByUsername(String username);
}