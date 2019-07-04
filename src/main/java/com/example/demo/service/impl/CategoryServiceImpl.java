package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;

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
		categoryRepository.deleteById(categoryId);	}
	
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

}
