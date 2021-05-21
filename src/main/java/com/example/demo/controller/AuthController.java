package com.example.demo.controller;


import com.example.demo.model.JwtResponse;
import com.example.demo.model.LoginUser;
import com.example.demo.service.appUserService.appUser.AppUserService;
import com.example.demo.service.jwtService.JwtService;
import com.example.demo.tokenService.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AppUserService userService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginUser user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        LoginUser currentUser = userService.findByUsername(user.getUsername()).get();
        return ResponseEntity.ok(new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @GetMapping("currentUser")
    public ResponseEntity<LoginUser> getCurrentUser(HttpServletRequest request){
        String token=tokenService.getJwtFromRequest(request);
        LoginUser appUser=userService.getUserCurrent(jwtService,token);
        return new ResponseEntity<>(appUser,HttpStatus.OK);
    }
    @GetMapping("/logot")
    public String logout(HttpServletRequest request){
        String token=tokenService.getJwtFromRequest(request);
        tokenService.delete(token);
        return "succsess";
    }


}

