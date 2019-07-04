package com.example.demo.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.service.ProductService;

@Controller
@RequestMapping(value = "/admin/product")
public class AdminProductController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String pageAdminProduct() {
		return "admin/admin-product";
	}

}
