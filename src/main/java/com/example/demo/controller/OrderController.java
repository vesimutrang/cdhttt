package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ApiResponseModel;
import com.example.demo.model.OrderCreation;
import com.example.demo.service.OrderService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/api")
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@PostMapping("/order")
	public ResponseEntity<Object> createOrder(@RequestBody OrderCreation order) {
		ApiResponseModel responseModel = new ApiResponseModel();
		try {
			responseModel.setData(orderService.createOrder(order));
		} catch (NotFoundException e) {
			responseModel.setData(false);
		}
        return ResponseEntity.ok(responseModel);
	}
}
