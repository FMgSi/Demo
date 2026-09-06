package com.example.demo.repository;

import com.example.demo.models.Brand;
import com.example.demo.models.Product;
import com.example.demo.models.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByProductNameContainingIgnoreCase(String keyword);
    List<Product> findByPriceLessThanEqual(BigDecimal price);
    List<Product> findByBrand(Brand brand);
    List<Product> findByBrand_BrandId(Integer brandId);
}
