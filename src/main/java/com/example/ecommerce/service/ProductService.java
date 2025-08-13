package com.example.ecommerce.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.model.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private TagService tagService;
	
	
	// Create
	// Add a parameter categoryId so that I can retrieve the category
	// Add a parameter tags List<Long> so that I can retrive the tags
	public Product createProduct(Product product, Long categoryId, List<Long> tagIds) {
		
		// When I create a new product, I will get the category from categoryId
		// and set it to the product
		product.setCategory(categoryService.get(categoryId));
		
		// When I create a new product, I will get the tags from tagIds
		// and set it to the product
		// transform it to Set (to ensure no repeated tags)
		product.setTags(Set.copyOf(tagService.getByIds(tagIds)));
		
		return productRepository.save(product);
	}
	
	
	// Read
	
	public List<Product> getAllProducts(){
	
		return productRepository.findAll();
	}
	
	
	//Read by Id
	
	
	//Update
	
	
	
	// Delete

}
