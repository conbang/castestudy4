package com.example.demo.controller;

import com.example.demo.service.ICustomerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin()
@RestController
@RequestMapping("/api/v1/loginUser")
public class LoginUserController {

    private final ICustomerService customerService;

    public LoginUserController(ICustomerService customerService) {
        this.customerService = customerService;
    }
}
