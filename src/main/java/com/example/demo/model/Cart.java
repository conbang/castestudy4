package com.example.demo.model;

import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class Cart {


    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    private boolean checkItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return true;
            }
        }
        return false;
    }


    private Map.Entry<Product, Integer> selectItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId().equals(product.getId())) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        if (!checkItemInCart(product)) {
            products.put(product, 1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            products.put(itemEntry.getKey(), newQuantity);
        }
    }

    public void minusProduct(Product product) {
        Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
        Integer newQuantity = itemEntry.getValue();

        System.out.println(itemEntry.getKey().getName());

        if (newQuantity >= 1) {
            newQuantity -= 1;
            products.put(itemEntry.getKey(), newQuantity);
        }
        if (newQuantity == 0) {
            Set<Product> setKey = products.keySet();
            for (Product p : setKey) {
                if (p.getId().equals(product.getId())) {
                    products.remove(p);
                    break;
                }
            }
        }
    }

    public void deleteCart(Product product) {
        Set<Product> setKey = products.keySet();
        for (Product p : setKey) {
            if (p.getId().equals(product.getId())) {
                products.remove(p);
            }
        }
    }

    public Integer countProductQuantity() {
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity() {
        return products.size();
    }

    public Float countTotalPayment() {
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
}
