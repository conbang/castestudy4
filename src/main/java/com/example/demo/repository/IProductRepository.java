package com.example.demo.repository;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.model.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {

    Page<Product> findProductsByShop(Shop shop, Pageable pageable);

    Page<Product> findProductsByShopAndCategory(Shop shop, Category category,Pageable pageable);
    Iterable<Product> findProductsByShopAndCategory(Shop shop, Category category);

    Iterable<Product> findProductByNameContaining(String string);

}
