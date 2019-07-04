package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Role;


public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByName(String roleName);
}
