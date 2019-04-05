package com.project.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
