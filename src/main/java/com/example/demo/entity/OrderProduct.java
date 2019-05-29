package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "generator")
	private Long id;
	
	@Column(name="quanlity", nullable = false)
	private Integer quanlity;
	
	@ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
	@JsonIgnore
    private Product product;
	
	@ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
	@JsonIgnore
    private Order order;
	
	public OrderProduct() {
		super();
	}
	
	
	public OrderProduct(Integer quanlity, Product product, Order order) {
		super();
		this.quanlity = quanlity;
		this.product = product;
		this.order = order;
	}


	public OrderProduct(Product product, Order order) {
		super();
		this.product = product;
		this.order = order;
	}

	public OrderProduct(Long id, Product product, Order order) {
		super();
		this.id = id;
		this.product = product;
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Integer getQuanlity() {
		return quanlity;
	}


	public void setQuanlity(Integer quanlity) {
		this.quanlity = quanlity;
	}
	
}
