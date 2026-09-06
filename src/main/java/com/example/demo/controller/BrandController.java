package com.example.demo.controller;

import com.example.demo.models.Brand;
import com.example.demo.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/brands")
public class BrandController {
    private final BrandService brandService;

    @PostMapping("")
    public Brand addBrand(@RequestBody Brand brand){
        return brandService.createBrand(brand);
    }

    @GetMapping("")
    public List<Brand> getBrand(){
        return brandService.getAllBrand();
    }

    @GetMapping("/{id}")
    public Brand getByIdBrand(@PathVariable Integer id){
        return brandService.getByIdBrand(id);
    }
}
