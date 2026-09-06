package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_Id", nullable = false)
    private int productId;

    private String productName;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private int stockQuantity;
    private String thumbnailUrl;
    private String description;
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "category_Id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_Id")
    private Brand brand;

    @OneToMany(mappedBy = "product")
    @com.fasterxml.jackson.annotation.JsonIgnore
    private List<ProductImage> productImages = new ArrayList<>();

    @OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
    @com.fasterxml.jackson.annotation.JsonIgnore
    @JoinColumn(name = "product_Specification_Id", referencedColumnName = "id")
    private ProductSpecification productSpecification;

    @OneToMany(mappedBy = "product")
    @com.fasterxml.jackson.annotation.JsonIgnore
    private List<CartItem> cartItems = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    @com.fasterxml.jackson.annotation.JsonIgnore
    private List<OrderDetail> orderDetails = new ArrayList<>();
}
