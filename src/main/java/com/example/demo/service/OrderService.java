package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.OrderCreation;

import javassist.NotFoundException;

@Service
public interface OrderService {
	public boolean createOrder(OrderCreation order) throws NotFoundException;
}
