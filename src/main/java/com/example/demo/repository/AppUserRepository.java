package com.example.demo.repository;

import com.example.demo.model.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<LoginUser, Long> {
    LoginUser getLoginUserByUsername(String username);
    Optional<LoginUser> findByUsername(String username);
    Boolean existsByEmail(String email);
    Boolean existsByUsername(String username);
    LoginUser findAppUserByUsername(String username);
}