package com.project.dao;

import org.springframework.data.repository.CrudRepository;

import com.project.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByUsername(String username);
}
