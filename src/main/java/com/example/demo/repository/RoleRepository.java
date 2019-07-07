package com.example.demo.repository;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

import com.example.demo.entity.Role;


public interface RoleRepository extends DataTablesRepository<Role, Long> {
	Role findByName(String roleName);
}
