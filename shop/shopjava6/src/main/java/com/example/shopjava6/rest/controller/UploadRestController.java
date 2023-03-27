package com.example.shopjava6.rest.controller;

import java.io.File;

import jakarta.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.example.shopjava6.entity.Order;
import com.example.shopjava6.entity.Product;
import com.example.shopjava6.service.OrderService;
import com.example.shopjava6.service.ProductService;
import com.example.shopjava6.service.UploadService;

@CrossOrigin("*")
@RestController
public class UploadRestController {

	@Autowired
	UploadService upsv;
	
	@PostMapping("/rest/upload/{folder}")
	public JsonNode upload(@PathParam("file") MultipartFile file,
				@PathVariable("folder") String folder) {
		File saveFile = upsv.save(file,folder);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = mapper.createObjectNode();
		node.put("name", saveFile.getName());
		node.put("size", saveFile.length());
		return node;
	}
}
