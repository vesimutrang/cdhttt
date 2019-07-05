package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.example.demo.entity.Category;


public interface CategoryRepository extends DataTablesRepository<Category, Long> {


	// Select category Perant
	List<Category> findByCategoryParentIsNull();

	Category findTopByOrderByNameDesc();

}
