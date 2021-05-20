package com.example.demo.repository;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.model.Shop;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {

    Iterable<Product> findProductsByShop(Shop shop);

    Iterable<Product> findProductsByShopAndCategory(Shop shop, Category category);

    Iterable<Product> findProductByNameContaining(String string);

}
