package com.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.model.Product;
import com.practice.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	// Create a new product
	@PostMapping("/add")
	public String createProduct(@RequestBody Product product) {
		boolean f = productService.saveProduct(product);
		if (f==true) {
			return "Product saved successfully";
		}else {
			return "Something went wrong";
		}
	}
	
	// Get all products
	@GetMapping
	public List<Product> getProduct(){
		return productService.getAllProducts();
	}
	
	// Get details by product ID
	@GetMapping("/{id}")
	public Product getById(@PathVariable("id") int id) {
		return productService.getById(id);
	}
	
	// Update product details
	@PutMapping("/update/{id}")
	public String update(@PathVariable("id") int id, @RequestBody Product product) {
		boolean result = productService.updateProduct(id, product);
		if (result == true) {
			return "Product updated.....";
		} else {
			return "Something went wrong";
		}
	}
	
	
	
	
	
	
	
	
	
}
