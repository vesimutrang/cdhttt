package com.example.demo.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo = "product")
public class Product {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="name", nullable = false, length = 100)
	private String name;
	
	@Column(name="price", nullable = false)
	private Integer price;
	
	@Column(name="amount", nullable = false)
	private Integer amount;
	
	@Column(name="producer", nullable = true, length = 200)
	private String producer;
	
	@Column(nullable = true, length = 100)
	private String shortDescription;
	
	@Column(nullable = true, length = 2000)
	private String description;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="product")
	private Set<Image> images;

	
	public Product() {
		super();
	}

	public Product(String name, Integer price, Integer amount, String producer, String shortDescription,
			String description, Set<Image> images) {
		super();
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.producer = producer;
		this.shortDescription = shortDescription;
		this.description = description;
		this.images = images;
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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}
	
	
}
