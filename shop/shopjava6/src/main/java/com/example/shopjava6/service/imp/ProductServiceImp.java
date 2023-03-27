package com.example.shopjava6.service.imp;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.shopjava6.dao.ProductDao;
import com.example.shopjava6.entity.Product;
import com.example.shopjava6.service.ProductService;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	ProductDao pdao;

	@Override
	public List<Product> findAll() {
		return pdao.findAll();
	}

	@Override
	public Product findById(Integer id) {
		return pdao.findById(id).get();
	}

	@Override
	public List<Product> findAllByCate(String cid) {
		return null;
	}

	@Override
	public Page<Product> findAllByCate(String string, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
