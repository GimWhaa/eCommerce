package com.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	// Create
	public Category create(Category category) {
		return categoryRepository.save(category);
	}

	// Get by Id
	public Category get(Long id) {
		// findById return Optional<Category>
		// Safe way to indicate that the return data type can either be Category or null
		return categoryRepository.findById(id).orElseThrow(()
		// if it is null we throw an error -> we should return error message in
		// Controller
		-> new RuntimeException("Category not found"));
	}

	// Get All
	public List<Category> getAll() {
		// findAll return List<Category>
		return categoryRepository.findAll();
	}

}
