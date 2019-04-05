package com.project.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.entity.Category;
import com.project.exception.NotFoundException;
import com.project.exception.ResourceNotFoundException;
import com.project.service.CategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
public class CategoryController {
	
	@Autowired
    private CategoryService categoryService;

		 	@RequestMapping(value="/categories", method=RequestMethod.GET)
			public ResponseEntity<Iterable<Category>> getAllCats() {
				Iterable<Category> allCats = categoryService.getAllCategories();
				return new ResponseEntity<>(allCats, HttpStatus.OK);
			}
	 	
	 	  @RequestMapping(value="/categories/{id}", method = RequestMethod.GET)
		  public ResponseEntity<?> retrieveCategory(@PathVariable Long id) {
	 		  	
	 		 final Category category = categoryService.getCategoryById(id)
			  .orElseThrow(() -> new ResourceNotFoundException("The category " + id + " not found"));	 		 
	 		 return new ResponseEntity<>(category,HttpStatus.OK);
		    }
	 	  
	 		@RequestMapping(value="/categories", method=RequestMethod.POST)
	 		public ResponseEntity<?> createCat(@RequestBody Category category) {
	 			category = categoryService.createCategory(category);
	 			HttpHeaders responseHeaders = new HttpHeaders();
	 			URI newCategoryUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getId()).toUri();
	 			responseHeaders.setLocation(newCategoryUri);
	 			return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	 		}
	 		
	 		@RequestMapping(value="/categories/{categoryId}", method=RequestMethod.DELETE)
	 		public ResponseEntity<?> deleteCat(@PathVariable Long categoryId) {
	 			categoryService.deleteCategory(categoryId);
	 			return new ResponseEntity<>(HttpStatus.OK);
	 		}
	 		
	 		@RequestMapping(value="/categories/{categoryId}", method=RequestMethod.PUT)
	 		public ResponseEntity<?> updateCat(@PathVariable Long categoryId, @RequestParam(value="name", required=true) String newName) {
	 			final Category category = categoryService.getCategoryById(categoryId)
						  .orElseThrow(() -> new NotFoundException("category"));
	 			categoryService.updateCategory(category, newName);
	 			return ResponseEntity.ok(category);
	 		}
	 		
		
	 		
	 		
	 		
}