package com.example.demo.model;

public class Item {
	private Long id;
	private Integer quantity;

	public Item(Long id, Integer quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
