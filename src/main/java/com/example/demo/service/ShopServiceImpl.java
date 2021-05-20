package com.example.demo.service;

import com.example.demo.model.Shop;
import com.example.demo.repository.IShopRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ShopServiceImpl implements IShopService{

    private final IShopRepository shopRepository;

    public ShopServiceImpl(IShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public Optional<Shop> findShopById(long id) {
        return shopRepository.findById(id);
    }

    @Override
    public Shop save(Shop shop) {
        return shopRepository.save(shop);
    }

    @Override
    public void delete(Shop shop) {
        shopRepository.save(shop);
    }
}
