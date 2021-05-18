package com.example.demo.repository;

import com.example.demo.model.Shop;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShopRepository extends PagingAndSortingRepository<Shop,Long> {
}
