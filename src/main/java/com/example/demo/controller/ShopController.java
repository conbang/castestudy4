package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.model.Shop;
import com.example.demo.service.ICategoryService;
import com.example.demo.service.IProductService;
import com.example.demo.service.IShopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/shops")
public class ShopController {

    private final IProductService productService;
    private final IShopService shopService;
    private final ICategoryService categoryService;

    public ShopController(IProductService productService,
                          IShopService shopService,
                          ICategoryService categoryService) {
        this.productService = productService;
        this.shopService = shopService;
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<Iterable<Product>> getProductsByShop(@PathVariable("id") long id) {
        Optional<Shop> shop = shopService.findShopById(id);
        if (shop.isPresent()) {
            try {
                Iterable<Product> products = productService.findAllByShop(shop.get());
                if (products.iterator().hasNext()) {
                    return new ResponseEntity<>(products, HttpStatus.OK);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/products/{categoryId}")
    public ResponseEntity<Iterable<Product>> getProductByCategory(@PathVariable("id") long id,
                                                                  @PathVariable("categoryId") long categoryId) {

        Optional<Shop> shop = shopService.findShopById(id);
        Optional<Category> category = categoryService.findById(categoryId);
        if (shop.isPresent() && category.isPresent()) {
            Iterable<Product> products = productService.findAllByCategory(shop.get(), category.get());
            if (products.iterator().hasNext()) {
                return new ResponseEntity<>(products, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
