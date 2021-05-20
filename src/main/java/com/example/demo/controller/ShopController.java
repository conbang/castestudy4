package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.model.Shop;
import com.example.demo.service.ICategoryService;
import com.example.demo.service.IProductService;
import com.example.demo.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin()
@RestController
@RequestMapping("/api/v1/shops")
@PropertySource("classpath:application.properties")
public class ShopController {

    @Autowired
    Environment environment;
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
    public ResponseEntity<Iterable<Product>> getProductsByShop(@PathVariable("id") long id,
                                                               Pageable pageable) {
        Optional<Shop> shop = shopService.findShopById(id);
        if (shop.isPresent()) {
            try {
                Page<Product> products = productService.findAllByShop(shop.get(),pageable);
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
                                                                  @PathVariable("categoryId") long categoryId,
                                                                  Pageable pageable) {

        Optional<Shop> shop = shopService.findShopById(id);
        Optional<Category> category = categoryService.findById(categoryId);
        if (shop.isPresent() && category.isPresent()) {
            Page<Product> products = productService.findAllByCategory(shop.get(), category.get(), pageable);
            if (products.iterator().hasNext()) {
                return new ResponseEntity<>(products, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody Shop shop) {
        shopService.save(shop);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("{id}/products")
    public ResponseEntity<?> uploadProduct(@RequestBody Product uploadProduct) {

        List<MultipartFile> multipartFiles = uploadProduct.getMultipartFile();
        List<String> fileNames = new ArrayList<>();
        int numberImage = multipartFiles.size();
        if (numberImage != 0) {
            for (int i = 0; i < numberImage; i++) {
                String image = uploadProduct.getShop().getName() + multipartFiles.get(i).getOriginalFilename();
                String fileName;
                if (i == 0) {
                    fileName = "cover image" + image;
                } else {
                    fileName = image;
                }
                fileNames.add(fileName);
                try {
                    FileCopyUtils.copy(multipartFiles.get(i).getBytes(), new File(environment.getProperty("productImagePath") + fileName));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        String images = fileNames.stream().reduce((str1, str2) -> str1 + "," + str2).get();
        uploadProduct.setImage(images);
        productService.save(uploadProduct);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
