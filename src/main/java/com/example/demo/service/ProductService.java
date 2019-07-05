package com.example.demo.service;

import java.util.List;

import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductShortDTO;
import com.example.demo.entity.Product;

@Service
public interface ProductService {

	public List<Product> getAllProduct();
	
	public List<ProductShortDTO> getNewProductsAsShort();
	
	public Product getProduct(long id);

	public ProductShortDTO getProductsAsShort(Long id);
	
	DataTablesOutput<Product> findAll(DataTablesInput input);
	

}
