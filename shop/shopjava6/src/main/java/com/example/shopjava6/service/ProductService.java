package com.example.shopjava6.service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;

import com.example.shopjava6.entity.Product;

public interface ProductService {

	List<Product> findAll();

	Product findById(Integer id);

	List<Product> findAllByCate(String cid);

	Page<Product> findAllByCate(String string, Pageable pageable);

}
