package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public void delete(Long categoryId) {
		categoryRepository.deleteById(categoryId);
	}

	@Override
	public DataTablesOutput<Category> findAll(DataTablesInput input) {
		return categoryRepository.findAll(input);
	}

	@Override
	public Iterable<Category> getCategoryAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(Long categoryId) {
		return categoryRepository.findById(categoryId).get();
	}

	@Override
	public String categoryTreeJson() {
		List<Category> categories = categoryRepository.findByCategoryParentIsNull();

		ObjectMapper mapper = new ObjectMapper();

		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(categories);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonString;
	}

}
