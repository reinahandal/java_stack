package com.reinahandal.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.reinahandal.productsandcategories.models.Category;
import com.reinahandal.productsandcategories.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();
	// Retrieves a list of all products for a particular category
    List<Product> findAllByCategories(Category category);
    
    // Retrieves a list of any products a particular category does not belong to.
    List<Product> findByCategoriesNotContains(Category category);
}
