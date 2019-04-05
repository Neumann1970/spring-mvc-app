package com.project.service;


import java.util.Optional;

import com.project.entity.Category;

public interface CategoryService {
	
	Iterable<Category> getAllCategories();
	Optional<Category> getCategoryById(Long id);
	Category createCategory(Category category);
	Category updateCategory(Category category, String name);
	void deleteCategory(Long categoryId);

}
