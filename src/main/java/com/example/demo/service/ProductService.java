package com.example.demo.service;

import com.example.demo.dto.ProductRequest;
import com.example.demo.models.Brand;
import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.models.ProductSpecification;
import com.example.demo.repository.BrandRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;

    public Product createProduct(ProductRequest productRequest){
        Brand brand = brandRepository.findById(productRequest.getBrandId())
                .orElseThrow(() -> new RuntimeException("Khong tim thay brand id: " +  productRequest.getBrandId()));

        Category category = categoryRepository.findById(productRequest.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Khong tim thay category id: " + productRequest.getCategoryId()));        Product product = new Product();
        product.setProductName(productRequest.getProductName());
        product.setPrice(productRequest.getPrice());
        product.setDiscountPrice(productRequest.getDiscountPrice());
        product.setStockQuantity(productRequest.getStockQuantity());
        product.setThumbnailUrl(productRequest.getThumbnailUrl());
        product.setDescription(productRequest.getDescription());
        product.setActive(true);
        product.setBrand(brand);
        product.setCategory(category);

        if (productRequest.getSpecificationRequest() != null){
            ProductSpecification productSpecification = new ProductSpecification();
            productSpecification.setCpu(productRequest.getSpecificationRequest().getCpu());
            productSpecification.setGpu(productRequest.getSpecificationRequest().getGpu());
            productSpecification.setOs(productRequest.getSpecificationRequest().getOs());
            productSpecification.setRamGB(productRequest.getSpecificationRequest().getRamGB());
            productSpecification.setBatteryWh(productRequest.getSpecificationRequest().getBatteryWh());
            productSpecification.setRefreshRateHz(productRequest.getSpecificationRequest().getRefreshRateHz());
            productSpecification.setScreenSizeInch(productRequest.getSpecificationRequest().getScreenSizeInch());
            productSpecification.setStorageGB(productRequest.getSpecificationRequest().getStorageGB());
            productSpecification.setStorageType(productRequest.getSpecificationRequest().getStorageType());
            productSpecification.setWeightKg(productRequest.getSpecificationRequest().getWeightKg());
            productSpecification.setProduct(product);
            product.setProductSpecification(productSpecification);
        }
        return productRepository.save(product);
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public Product getByIdProduct(Integer id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Khong tim thay product id: " + id));
    }
}
