package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.model.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {

    Page<Product> findAll(Pageable pageable);

    Page<Product> findAllByShop(Shop shop, Pageable pageable);

    Page<Product> findAllByCategory(Shop shop, Category category, Pageable pageable);

    Product save(Product product);

    void delete(Product product);
}
