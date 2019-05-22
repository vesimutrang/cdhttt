package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductShortDTO;
import com.example.demo.entity.Product;
import com.example.demo.model.ApiResponseModel;
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
		List<ProductShortDTO> products = productService.getNewProductsAsShort();
		ApiResponseModel responseModel = new ApiResponseModel();
		if (products.size() != 0) {
			responseModel.setData(products);
			return ResponseEntity.ok(responseModel);
		} else {
			responseModel.setErrorMessage("Cannot found any product!");
			return new ResponseEntity<>(responseModel,HttpStatus.NOT_FOUND);
		}
    }
}
