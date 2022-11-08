package com.reinahandal.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.reinahandal.productsandcategories.models.Category;
import com.reinahandal.productsandcategories.models.Product;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();
	// Retrieves a list of all categories for a particular product
    List<Category> findAllByProducts(Product product);
    
    // Retrieves a list of any categories a particular product does not belong to.
    List<Category> findByProductsNotContains(Product product);

}
