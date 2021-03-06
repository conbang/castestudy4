package com.example.demo.model;

import com.example.demo.model.Category;
import com.example.demo.model.Shop;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @NotNull
    private Double price;

    private String description;

    private Date date_time;
    @NotNull
    private Long quantity;

    @Transient
    private List<MultipartFile> multipartFile;
    private String image;

    private Long soldNumber;
    private Double rate;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Shop shop;

    public Product() {
    }

    public Product(Long id, @NotEmpty String name,
                   @NotNull Double price, String description,
                   Date date_time, @NotNull Long quantity,
                   String image, Category category, Shop shop) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.date_time = date_time;
        this.quantity = quantity;
        this.image = image;
        this.category = category;
        this.shop = shop;
    }

    public List<MultipartFile> getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(List<MultipartFile> multipartFile) {
        this.multipartFile = multipartFile;
    }

    public Product(Long id, @NotEmpty String name,
                   @NotNull Double price, String description,
                   Date date_time, @NotNull Long quantity,
                   String image, Long soldNumber,
                   Double rate, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.date_time = date_time;
        this.quantity = quantity;
        this.image = image;
        this.soldNumber = soldNumber;
        this.rate = rate;
        this.category = category;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getSoldNumber() {
        return soldNumber;
    }

    public void setSoldNumber(Long soldNumber) {
        this.soldNumber = soldNumber;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", date_time=" + date_time +
                ", quantity=" + quantity +
                ", image='" + image + '\'' +
                ", soldNumber=" + soldNumber +
                ", rate=" + rate +
                ", category=" + category +
                ", shop=" + shop +
                '}';
    }
}
