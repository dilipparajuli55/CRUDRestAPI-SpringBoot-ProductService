package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
