package com.project.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	@Query(value="select p.* from Category c, Product p where c.CAT_ID = ?1 and c.CAT_ID=p.CAT_ID", nativeQuery = true)
	public Iterable<Product> findByCategory(Long categoryId);
	
}
