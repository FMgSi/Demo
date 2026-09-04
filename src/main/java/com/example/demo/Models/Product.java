package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ProductId;

    private String ProductName;
    private BigDecimal Price;
    private BigDecimal DiscountPrice;
    private int StockQuantity;
    private String ThumbnailUrl;
    private String Description;
    private boolean IsActive;

    @ManyToOne
    @JoinColumn(name = "category_Id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_Id")
    private Brand brand;

}
