package com.example.demo.service;

import java.util.Optional;

import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.example.demo.entity.User;



public interface UserService {

	User getUserByUsername(String username);

	Iterable<User> findAll();

	Optional<User> findOne(long id);

	User save(User user);

	User update(User user);

	void delete(long id);
	
	DataTablesOutput<User> findAll(DataTablesInput input);

}
