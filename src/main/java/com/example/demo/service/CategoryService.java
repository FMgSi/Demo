package com.example.demo.service;

import com.example.demo.models.Category;
import com.example.demo.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Integer id){
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Khong tim thay category voi id: " + id));
    }

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public void deleteCategory(Integer id){
        if (categoryRepository.existsById(id)){
            categoryRepository.deleteById(id);
        } else {
            throw new RuntimeException("Khong tim thay category co id: " + id);
        }
    }


}
