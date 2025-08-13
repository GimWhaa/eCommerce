package com.example.ecommerce.controller;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    /// Autowired is not recommended in controller because it creates a circular dependency.
    /// Circular dependency is when one class depends on another.
    /// In this case, CategoryController depends on CategoryService.
    /// CategoryService depends on CategoryController
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Category create(@Valid @RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @GetMapping
    public Iterable<Category> getAll() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }
}
