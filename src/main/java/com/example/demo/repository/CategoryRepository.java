package com.example.demo.repository;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.example.demo.entity.Category;

public interface CategoryRepository extends DataTablesRepository<Category, Long> {
}
