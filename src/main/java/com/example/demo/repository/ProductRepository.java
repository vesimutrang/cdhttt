package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findFirst10ByOrderById();

	Page<Product> findByCategoryCategoryId(Long categoryid, Pageable pageable);
}
