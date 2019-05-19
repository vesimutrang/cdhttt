package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductShortDTO;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public List<ProductShortDTO> getNewProductsAsShort() {
		// TODO Auto-generated method stub
		List<Product> products = productRepository.findFirst10ByOrderById();
		List<ProductShortDTO> productShorts = new ArrayList<>();
		products.forEach(product -> {
			if (product != null) {
				ProductShortDTO productShort = new ProductShortDTO(product.getId(), product.getName(), product.getPrice(), 
						product.getProducer(), product.getShortDescription());
				if (product.getImages().size() != 0) {
					productShort.setImage(product.getImages().iterator().next().getSource());
				}
				productShorts.add(productShort);
			}
		});
		return productShorts;
	}
}
