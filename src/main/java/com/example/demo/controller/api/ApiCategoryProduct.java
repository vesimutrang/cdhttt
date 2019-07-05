package com.example.demo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Controller
@RequestMapping(value = "/api/product")
public class ApiCategoryProduct {
	@Autowired
	ProductRepository productRepository;

	@ResponseBody
	@RequestMapping(value = "/json", method = RequestMethod.GET)
	public Page<Product> _demoProduct() {
		System.out.println("okoko");
		return productRepository.findByCategoryCategoryId(15l, PageRequest.of(0, 8));
	}
}
