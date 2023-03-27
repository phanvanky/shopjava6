package com.example.shopjava6.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shopjava6.entity.Category;

public interface CategoryDao extends JpaRepository<Category, String> {
	
}
