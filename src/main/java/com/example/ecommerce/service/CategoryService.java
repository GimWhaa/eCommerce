package com.example.ecommerce.service;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Create a new category
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Get all categories
    public Iterable<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Get a category by id
    public Category getCategoryById(Long id) {
        // findById returns an Optional
        // Safe way to indicate that the return value can be null
        return categoryRepository.findById(id).orElseThrow(() -> (new RuntimeException("Category not found")));
    }

}
