package com.reinahandal.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reinahandal.productsandcategories.models.Category;
import com.reinahandal.productsandcategories.models.Product;
import com.reinahandal.productsandcategories.services.CategoryService;
import com.reinahandal.productsandcategories.services.ProductService;

@Controller
public class MainController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("products", productService.getAllProducts());
		return "index.jsp";
	}
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "newproduct.jsp";
	}
	
	@PostMapping("/products/create")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "newproduct.jsp";
		}
		else {
			productService.createProduct(product);
			return "redirect:/";
		}
	}
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "newcategory.jsp";
	}
	@PostMapping("/categories/create")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "newcategory.jsp";
		}
		else {
			categoryService.createCategory(category);
			return "redirect:/";
		}
	}
	@GetMapping("/categories/{categoryId}")
	public String showCategory(
			@PathVariable("categoryId") Long id,
			Model model,
			@ModelAttribute("category") Category category) {
		Category thisCategory = categoryService.findCategory(id);
		model.addAttribute("category", thisCategory);
		model.addAttribute("excludedProducts", productService.getExcludedProducts(thisCategory));
		return "showcategory.jsp";
	}
	
	// processes form that adds product to category 
	@PostMapping("/categories/addproduct/")
	public String addProductToCategory(
			@RequestParam("category") Long categoryId,
			@RequestParam("product") Long productId) {
		Category thisCategory = categoryService.findCategory(categoryId);
		Product thisProduct = productService.findProduct(productId);
		List<Category> product1Categ = thisProduct.getCategories();
		product1Categ.add(thisCategory);
		thisProduct.setCategories(product1Categ);
		productService.updateProduct(thisProduct);
 		return "redirect:/";
	}

	@GetMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product product = productService.findProduct(id);
		model.addAttribute("product", product);
		model.addAttribute("excludedCategories", categoryService.getExcludedCategories(product));
		return "showproduct.jsp";
	}
	
}
