package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "productSpecification")
@Getter
@Setter
public class ProductSpecification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_Specification_Id")
    private Integer productSpecificationId;

    private String cpu;
    private int ramGB;
    private int storageGB;
    private String storageType;
    private String gpu;
    private BigDecimal screenSizeInch;
    private int refreshRateHz;
    private BigDecimal weightKg;
    private int batteryWh;
    private String os;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_Id")
    @com.fasterxml.jackson.annotation.JsonIgnore
    private Product product;

}
