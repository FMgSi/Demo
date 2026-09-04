package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "productImage")
@Getter
@Setter
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_Id", nullable = false)
    private int ImageId;
    private String ImageUrl;
    private int DisplayOrder;

    @ManyToOne
    @JoinColumn(name = "product_Id")
    private Product product;
}
