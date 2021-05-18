package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.model.Shop;

public interface IProductService{

    Iterable<Product> findAllByShop(Shop shop);

    Iterable<Product> findAllByCategory(Shop shop, Category category);

    Product save(Product product);

    void delete(Product product);
}
