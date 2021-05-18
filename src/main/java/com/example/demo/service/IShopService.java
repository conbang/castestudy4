package com.example.demo.service;

import com.example.demo.model.Shop;
import java.util.Optional;

public interface IShopService {

    Optional<Shop> findShopById(long id);
}
