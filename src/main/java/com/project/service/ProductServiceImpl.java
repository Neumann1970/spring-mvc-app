package com.project.service;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.ProductRepository;
import com.project.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	
	@Autowired
	private ProductRepository productRepository;

	@Transactional
	@Override
	public Iterable<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@Transactional
	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		Product saveProduct = productRepository.save(product);
		return saveProduct;
	}
	
	@Transactional
	@Override
	public Optional<Product> getProductById(Long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@Transactional
	@Override
	public void deleteProductById(Long productId) {
		// TODO Auto-generated method stub
		productRepository.deleteById(productId);

	}
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@Transactional
	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		productRepository.delete(product);

	}
	
	@Transactional
	@Override
	public Iterable<Product> getProductByCat(Long categoryId) {
		// TODO Auto-generated method stub
		return productRepository.findByCategory(categoryId);
	}
	
	
	
}
