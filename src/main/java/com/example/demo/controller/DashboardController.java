package com.example.demo.controller;

import com.example.demo.model.LoginUser;
import com.example.demo.service.appUserService.appUser.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DashboardController {
    @Autowired
    private AppUserService appUserService;
    @ModelAttribute("currentUser")
    private LoginUser getCurrentUser() {
        return appUserService.getCurrentUser();
    }
    @GetMapping("/dashboard")
    public String home() {
        return "/shop/home";
    }
}
