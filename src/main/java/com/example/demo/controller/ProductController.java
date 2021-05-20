package com.example.demo.controller;

import com.example.demo.service.IProductService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

}
