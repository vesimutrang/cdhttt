package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo = "image")
public class Image {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="name", nullable = false, length = 100)
	private String name;
	
	@Column(name="description", nullable = true, length = 200)
	private String description;
	
	@Column(name="source", nullable = false, columnDefinition="TEXT")
	private String source;
	
	@ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

	public Image(String name, String description, String source) {
		super();
		this.name = name;
		this.description = description;
		this.source = source;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
 
	
}