package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.model.Shop;
import com.example.demo.repository.IProductRepository;
import com.example.demo.service.IProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

    private final IProductRepository productRepository;

    public ProductServiceImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> findAllByShop(Shop shop) {
        return productRepository.findProductsByShop(shop);
    }

    @Override
    public Iterable<Product> findAllByCategory(Shop shop, Category category) {
        return productRepository.findProductsByShopAndCategory(shop, category);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Product product) {

    }
}
