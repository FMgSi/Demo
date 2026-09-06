package com.example.demo.service;

import com.example.demo.models.Brand;
import com.example.demo.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Service
public class BrandService {
    private final BrandRepository brandRepository;

    public Brand createBrand(Brand brand){
        return brandRepository.save(brand);
    }

    public Brand getByIdBrand(Integer id){
        return brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Khong tim thay brand id: "+ id));
    }

    public List<Brand> getAllBrand(){
        return brandRepository.findAll();
    }

    public void deleteBrand(Integer id){
        if (brandRepository.existsById(id)){
            brandRepository.deleteById(id);
        } else {
            throw new RuntimeException("Khong tim thay brand id: "+ id);
        }
    }
}
