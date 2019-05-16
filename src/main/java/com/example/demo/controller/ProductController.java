package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<Object> products() {
		List<Product> products = productService.getAllProduct();
        return ResponseEntity.ok(products);
    }
	
	@GetMapping("/newProducts")
	public ResponseEntity<Object> newProducts() {
		List<Product> products = productService.getNewProducts();
        return ResponseEntity.ok(products);
    }
}
