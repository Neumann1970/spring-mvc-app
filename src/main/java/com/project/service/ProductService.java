package com.project.service;

import java.util.Optional;

import com.project.entity.Product;

public interface ProductService {
	
	 Iterable<Product> getAllProducts();
	 Product addProduct(Product product);
	 Optional<Product> getProductById(Long id);
	 void deleteProductById(Long id);
	 Iterable<Product> getProductByCat(Long categoryId);
	 void deleteProduct(Product product);

}
