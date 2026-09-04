package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "brand")
@Getter
@Setter
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_Id", nullable = false, length = 150)
    private int BrandId;

    private String BrandName;

    private String LogoUrl;

    @OneToMany(mappedBy = "brand")
    private List<Product> products = new ArrayList<>();
}
