package com.practice.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.practice.model.Product;

@Service
public interface ProductService {

	boolean saveProduct(Product product);

	List<Product> getAllProducts();

	Product getById(int id);

	boolean updateProduct(int id, Product product);
}
