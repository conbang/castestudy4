package com.example.demo.controller;

import com.example.demo.model.Cart;

import com.example.demo.model.Product;
import com.example.demo.service.ProductServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.demo.service.IProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin()
@RestController
@RequestMapping("/api/v1/products")
@SessionAttributes("cart")
public class ProductController {
    private IProductService productService;
    public ProductController(IProductService productService) {
        this.productService = productService;
    }
    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping
    public ResponseEntity<Iterable<Product>> showShop() {
        List<Product> products = (List<Product>) productService.findAll();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/quantity")
    public ResponseEntity<Integer> countProduct(@ModelAttribute("cart") Cart cart) {
        Map<Product, Integer> products = cart.getProducts();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Integer quantity = cart.countProductQuantity();
        return new ResponseEntity<>(quantity, HttpStatus.OK);
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<Iterable<Product>> findAllByName(@PathVariable String name) {
        return new ResponseEntity<>(productService.findAllByName(name), HttpStatus.OK);
    }

    @GetMapping("/shopping-cart")
    public ResponseEntity<Map<Product, Integer>> showCart(@ModelAttribute("cart") Cart cart) {
        Map<Product, Integer> products = cart.getProducts();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    @GetMapping("/shop")
    public ModelAndView getAllProduct() {
        ModelAndView modelAndView = new ModelAndView("/customers/product-list");
        return modelAndView;
    }

    @GetMapping("/productDetail")
    public ModelAndView getAllProductDetail() {
        ModelAndView modelAndView = new ModelAndView("/customers/product-detail");
        return modelAndView;
    }

    @GetMapping("/index")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("/customers/index");
        return modelAndView;
    }

    @GetMapping("/cart")
    public ModelAndView getAllCart() {
        ModelAndView modelAndView = new ModelAndView("/customers/cart");
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public ResponseEntity<Product> addToCart(@PathVariable Long id, @ModelAttribute("cart") Cart cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        cart.addProduct(productOptional.get());
        return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/addCart/{id}")
    public ModelAndView plusCart(@PathVariable Long id, @ModelAttribute("cart") Cart cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/error.404");
        }
        cart.addProduct(productOptional.get());
        ModelAndView modelAndView = new ModelAndView("/customers/cart");
        return modelAndView;
    }


    @GetMapping("/minus/{id}")
    public ModelAndView minusToCart(@PathVariable Long id, @ModelAttribute("cart") Cart cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/error.404");
        }
        cart.minusProduct(productOptional.get());
        ModelAndView modelAndView = new ModelAndView("/customers/cart");
        return modelAndView;
    }

    @GetMapping("/deleteCart/{id}")
    public ModelAndView deleteCart(@PathVariable Long id, @ModelAttribute("cart") Cart cart) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/error.404");
        }
        cart.deleteCart(productOptional.get());
        ModelAndView modelAndView = new ModelAndView("/customers/cart");
        return modelAndView;
    }
}
