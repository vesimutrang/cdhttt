package com.example.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "generator")
	private Long id;
	
	@Column(name="name", nullable = false, length = 100)
	private String name;
	
	// more information: birthday, gender..

	@OneToMany(mappedBy="account", cascade = CascadeType.ALL)
	private Set<Order> orders;

	public Account() {
		super();
	}

	public Account(String name) {
		super();
		this.name = name;
	}

	public Account(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
}
