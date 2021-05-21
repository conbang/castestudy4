package com.example.demo.service.appUserService.loginuser;

import com.example.demo.model.LoginUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ILoginUserService{
    List<LoginUser> findALl();

    Page<LoginUser> findALl(Pageable pageable);

    LoginUser findById(Long id);

    LoginUser save(LoginUser t);

    void deleteById(Long id);

}