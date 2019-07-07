package com.example.demo.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.CategoryService;

@Controller
@RequestMapping(value = "/api/category")
public class ApiCategoryControlle {
	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "/json-tree", method = RequestMethod.GET)
	@ResponseBody
	public String getCategoryJsonTree() {
		String jsonCategoryTree = categoryService.categoryTreeJson();
		System.out.println(jsonCategoryTree);
		return jsonCategoryTree;
	}
}
