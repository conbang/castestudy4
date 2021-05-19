package com.example.demo.repository;


import com.example.demo.model.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<LoginUser, Long> {
    Optional<LoginUser> findByUsername(String username);
}