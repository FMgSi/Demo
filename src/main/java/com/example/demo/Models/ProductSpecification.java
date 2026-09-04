package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "productSpecification")
@Getter
@Setter
public class ProductSpecification {
    private int ProductId;
    private String CPU;
    private int RamGB;
    private int StorageGB;
    private String StorageType;
    private String GPU;
    private BigDecimal ScreenSizeInch;
    private int RefreshRateHz;
    private BigDecimal WeightKg;
    private int BatteryWh;
    private String OS;

}
