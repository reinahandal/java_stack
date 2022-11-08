package com.reinahandal.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.reinahandal.productsandcategories.models.Category;
import com.reinahandal.productsandcategories.models.Product;
import com.reinahandal.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository=categoryRepository;
	}
	
	// creates category
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	// returns all categories
	public List<Category> getAllCategories(){
		return categoryRepository.findAll();
	}
	
	// retrieves category
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}
	
	// retrieves all categories for a particular product
	public List<Category> getProductCategories(Product product){
		return categoryRepository.findAllByProducts(product);
	}
	
	// retrieves categories a product does not belong to
	public List<Category> getExcludedCategories(Product product){
		return categoryRepository.findByProductsNotContains(product);
	}
	
}

