package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_Id", nullable = false, length = 150)
    private int CategoryId;

    private String CategoryName;

    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();
}
