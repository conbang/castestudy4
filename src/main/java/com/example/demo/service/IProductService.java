package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.model.Shop;

import java.util.Optional;

public interface IProductService{

    Iterable<Product> findAllByShop(Shop shop);

    Iterable<Product> findAllByCategory(Shop shop, Category category);

    Product save(Product product);

    void delete(Product product);
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
    Iterable<Product> findAllByName(String string);

}
