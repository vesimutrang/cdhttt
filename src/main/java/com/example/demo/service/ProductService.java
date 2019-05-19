package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductShortDTO;
import com.example.demo.entity.Product;

@Service
public interface ProductService {

	public List<Product> getAllProduct();
	
	public List<ProductShortDTO> getNewProductsAsShort();
}
