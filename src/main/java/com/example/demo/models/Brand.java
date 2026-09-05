package com.example.demo.models;

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
    @Column(name = "brand_Id", nullable = false)
    private int brandId;

    private String brandName;

    private String logoUrl;

    @OneToMany(mappedBy = "brand")
    private List<Product> products = new ArrayList<>();
}
