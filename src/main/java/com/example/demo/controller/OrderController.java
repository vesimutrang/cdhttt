package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.OrderCreation;

@RestController()
@RequestMapping("/api")
public class OrderController {
	@PostMapping
	public ResponseEntity<Object> createOrder(@RequestBody OrderCreation order) {
		return null;
	}
}
