package com.project.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.CategoryRepository;
import com.project.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
    private CategoryRepository categoryRepository;
	

	@Transactional
	@Override
	public Iterable<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Transactional	
	@Override
	public Optional<Category> getCategoryById(Long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id);
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@Transactional
	@Override
	public Category createCategory(Category category) {
		// TODO Auto-generated method stub
		 return categoryRepository.save(category);
	}

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@Transactional
	@Override
	public Category updateCategory(Category category, String name) {
		// TODO Auto-generated method stub
		category.setName(name);
		return categoryRepository.save(category);
	}
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@Transactional
	@Override
	public void deleteCategory(Long categoryId) {
		// TODO Auto-generated method stub
		categoryRepository.deleteById(categoryId);
	}
}
