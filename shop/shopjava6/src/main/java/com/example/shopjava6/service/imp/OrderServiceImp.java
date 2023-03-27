package com.example.shopjava6.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.shopjava6.dao.OrderDao;
import com.example.shopjava6.dao.OrderdetailDao;
import com.example.shopjava6.entity.Order;
import com.example.shopjava6.entity.Orderdetail;
import com.example.shopjava6.service.OrderService;


@Service
public class OrderServiceImp implements OrderService {

	@Autowired
	OrderDao dao;
	
	@Autowired
	OrderdetailDao oddao;

	@Override
	public Order create(JsonNode order) {
		ObjectMapper mapper = new ObjectMapper();
		
		Order ord = mapper.convertValue(order, Order.class);
		dao.save(ord);
		
		TypeReference<List<Orderdetail>> type = new TypeReference<List<Orderdetail>>() {};
		List<Orderdetail> details = mapper.convertValue(order.get("orderdetails"), type)
				.stream().peek(d -> d.setOrder(ord)).collect(Collectors.toList());
		oddao.saveAll(details);
		
		return ord;
	}

	@Override
	public Order findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public List<Order> findByUser(String username) {
		return dao.findByUser(username);
	}
	
	
}
