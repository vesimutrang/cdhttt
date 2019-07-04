package com.example.demo.service;

import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.example.demo.entity.Category;

public interface CategoryService {

	Category save(Category category);

	void delete(Long categoryId);

	DataTablesOutput<Category> findAll(DataTablesInput input);

	Iterable<Category> getCategoryAll();

	Category getCategoryById(Long categoryId);
}
