package com.example.demo.model;

import javax.persistence.*;

@Entity
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToOne
    private Product product;

    private String color;

    private String size;

    private Long quantity;
    public ProductDetail(Long id, Product product, String color, String size, Long quantity) {
        this.id = id;
        this.product = product;
        this.color = color;
        this.size = size;
        this.quantity = quantity;
    }

    public ProductDetail() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
