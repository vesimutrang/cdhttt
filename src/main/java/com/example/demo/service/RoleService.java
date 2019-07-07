package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import com.example.demo.entity.Role;



public interface RoleService {
	Iterable<Role> findAll();

	List<Role> search(String q);

	Optional<Role> findOne(long id);

	Role save(Role role);

	void delete(long id);

	Role update(Role role);
	
	DataTablesOutput<Role> findAll(DataTablesInput input);

}
