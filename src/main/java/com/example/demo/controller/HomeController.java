//package com.example.demo.controller;
//
//import com.example.demo.service.ProductServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//@Controller
//@RequestMapping("/home")
//public class HomeController {
//    @Autowired
//    private ProductServiceImpl productService;
//
//    @GetMapping("/shop")
//    public ModelAndView getAllProduct() {
//        ModelAndView modelAndView = new ModelAndView("/customers/shop");
//        modelAndView.addObject("products", productService.findAll());
//        return modelAndView;
//    }
//}
