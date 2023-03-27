package com.example.shopjava6.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.shopjava6.entity.Product;
import com.example.shopjava6.service.ProductService;

import jakarta.validation.constraints.AssertFalse.List;


@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
	
    @RequestMapping("/product/list")
    public String list(Model model){
    	java.util.List<Product>  list = productService.findAll();
    		model.addAttribute("items",list);
        return "/product/list";
    }
    @RequestMapping("/product/detail/{id}")
    public String detail(){
        return "/product/detail";
    }
}
