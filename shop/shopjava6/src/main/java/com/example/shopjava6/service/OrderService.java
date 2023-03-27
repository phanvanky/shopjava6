package com.example.shopjava6.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.example.shopjava6.entity.Order;

public interface OrderService {

	Order create(JsonNode order);

	Order findById(Long id);

	List<Order> findByUser(String username);



}
