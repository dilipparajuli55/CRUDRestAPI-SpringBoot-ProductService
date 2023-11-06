package com.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import com.practice.model.Product;
import com.practice.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public boolean saveProduct(Product product) {
		productRepository.save(product);
		return true;
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getById(int id) {
		Product product = productRepository.findById(id)
							.orElseThrow(()-> new HttpStatusCodeException(HttpStatus.NOT_FOUND, "Invalid product id" + id) {
								private static final long serialVersionUID = 1L;
							});
		return product;
	}

	@Override
	public boolean updateProduct(int id, Product product) {
		// check if the product is in the database
		productRepository.findById(id)
		.orElseThrow(()-> new HttpStatusCodeException(HttpStatus.NOT_FOUND, "Invalid product id" + id) {
			private static final long serialVersionUID = 1L;
		});
		try {
			product.setId(id);
			productRepository.save(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
}
