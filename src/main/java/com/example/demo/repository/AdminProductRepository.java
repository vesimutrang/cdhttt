package com.example.demo.repository;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.example.demo.entity.Product;

public interface AdminProductRepository extends DataTablesRepository<Product, Long>{

}
