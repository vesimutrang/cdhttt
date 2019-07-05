package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.repository.RoleRepository;
import com.example.demo.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Iterable<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public List<Role> search(String q) {
		return null;
	}

	@Override
	public Optional<Role> findOne(long id) {
		return roleRepository.findById(id);
	}

	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Role update(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public void delete(long id) {
		roleRepository.deleteById(id);
	}

	@Override
	public DataTablesOutput<Role> findAll(DataTablesInput input) {
		return roleRepository.findAll(input);
	}

}