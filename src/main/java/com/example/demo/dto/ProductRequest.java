package com.example.demo.dto;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductRequest {
    private String productName;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private int stockQuantity;
    private String thumbnailUrl;
    private String description;
    private boolean isActive;
    private Integer brandId;
    private Integer categoryId;

    private SpecificationRequest specificationRequest;
    @Getter
    @Setter
    public static class SpecificationRequest{
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
    }

}
