package com.example.demo.service.appUserService.appUser;



import com.example.demo.model.LoginUser;
import com.example.demo.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface IUserService extends IGeneralService<LoginUser>, UserDetailsService {
    Optional<LoginUser> findByUsername(String username);
}
