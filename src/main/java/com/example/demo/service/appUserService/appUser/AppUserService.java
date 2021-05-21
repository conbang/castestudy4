package com.example.demo.service.appUserService.appUser;

import com.example.demo.model.LoginUser;
import com.example.demo.model.UserPrinciple;
import com.example.demo.repository.AppUserRepository;
import com.example.demo.service.jwtService.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AppUserService implements IAppUserService, UserDetailsService {
    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Boolean existsByEmail(String email) {
        return appUserRepository.existsByEmail(email);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return appUserRepository.existsByUsername(username);
    }

    @Override
    public LoginUser getUserCurrent(JwtService jwtService, String token) {
        LoginUser appUser;
        String name= jwtService.getUserNameFromJwtToken(token);
//        Object ob = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        if (ob instanceof UserDetails){
//            name = ((UserDetails)ob).getUsername();
//        }
//        else {
//            name = ob.toString();
//        }
        System.out.println(name);
        appUser = this.findAppUserByUsername(name);

        return appUser;
    }

    @Override
    public LoginUser findAppUserByUsername(String username) {
        return  appUserRepository.findAppUserByUsername(username);
    }

    @Override
    public LoginUser getUserByUserName(String username) {
        return appUserRepository.getLoginUserByUsername(username);
    }

    @Override
    public LoginUser getCurrentUser() {
        LoginUser loginUser;
        String name;
        Object ob = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (ob instanceof UserDetails){
            name = ((UserDetails)ob).getUsername();
        }
        else {
            name = ob.toString();
        }
        loginUser = this.getUserByUserName(name);
        return loginUser;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<LoginUser> userOptional = appUserRepository.findByUsername(username);
        if (!userOptional.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        return UserPrinciple.build(userOptional.get());
    }

    @Override
    public Optional<LoginUser> findByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
}