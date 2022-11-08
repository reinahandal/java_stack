package com.reinahandal.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.reinahandal.productsandcategories.models.Category;
import com.reinahandal.productsandcategories.models.Product;
import com.reinahandal.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository=productRepository;
	}
	
	// creates product
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	// returns all products
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	// retrieves product
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}
	// retrieves all products for a particular category
	public List<Product> getCategoryProducts(Category category){
		return productRepository.findAllByCategories(category);
	}
	
	// retrieves products a category does not belong to
	public List<Product> getExcludedProducts(Category category){
		return productRepository.findByCategoriesNotContains(category);
	}
	
	// updates product
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}
}
