package com.project.controller;


import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.conditional.DiscountCalculator;
import com.project.entity.Category;
import com.project.entity.Product;
import com.project.exception.NotFoundException;
import com.project.service.CategoryService;
import com.project.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private List<DiscountCalculator> discountCalculators;

	
	@RequestMapping(value="/categories/{categoryId}/products/{productId}", method=RequestMethod.GET)
	public ResponseEntity<?> getProductById(@PathVariable Long categoryId, @PathVariable Long productId) {
		
		final Product product = productService.getProductById(productId)
				  .orElseThrow(() -> new NotFoundException("category"));
		return ResponseEntity.ok(product);
	}


	@RequestMapping(value="/categories/{categoryId}/products", method=RequestMethod.POST)
	public ResponseEntity<?> createProduct(@PathVariable Long categoryId, @RequestBody Product product) {
			
		final Optional<Category> category = categoryService.getCategoryById(categoryId);
		product.setCategory(category.get());
		product = productService.addProduct(product);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId()).toUri());
		
		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/categories/{categoryId}/products", method=RequestMethod.GET)
	public Iterable<Product> getAllProductsCat(@PathVariable Long categoryId) {
		
		Iterable<Product> forResponse = productService.getProductByCat(categoryId);
		
	  for (Iterator<Product> i = forResponse.iterator(); /* continue if */ i.hasNext(); /* skip increment */) {
			Product product = i.next();
		Double price = product.getPrice();
			
			for (DiscountCalculator calculator : this.discountCalculators){
			      System.out.println(calculator.getClass().getName());
			      price = calculator.applyDiscount(price);
			    }
			product.setPrice(price);			
		}
		return forResponse;
	}	

	@RequestMapping(value="/categories/{categoryId}/products/{productId}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteById(@PathVariable Long categoryId, @PathVariable Long productId) {	
		final Product product = productService.getProductById(productId)
				  .orElseThrow(() -> new NotFoundException("product"));
		
		productService.deleteProduct(product);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value="/categories/{categoryId}/products", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteProduct(@RequestBody Product product) {
		productService.deleteProduct(product);
		return new ResponseEntity<>(HttpStatus.OK);
	}		
}
	

