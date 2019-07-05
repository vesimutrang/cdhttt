package com.example.demo.repository;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.example.demo.entity.User;

public interface UserRepository extends DataTablesRepository<User, Long>{

	User findByUsername(String username);

}
