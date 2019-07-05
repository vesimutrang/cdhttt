package com.example.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "generator")
	private Long id;
	
	@Column(name="name", nullable = false, length = 100)
	private String name;
	
	@Column(name="price", nullable = false)
	private Integer price;
	
	@Column(name="max_quanlity", nullable = false)
	private Integer maxQuanlity;
	
	@Column(name="producer", nullable = true, length = 200)
	private String producer;
	
	@Column(nullable = true, length = 100)
	private String shortDescription;
	
	@Column(nullable = true, length = 2000)
	private String description;
	
	@OneToMany(mappedBy="product", cascade = CascadeType.ALL)
	private Set<Image> images;
	
	@OneToMany(mappedBy="product", cascade = CascadeType.ALL)
	private Set<OrderProduct> orderProducts;
	
	public Product() {
		super();
	}
	
	public Product(String name, Integer price, Integer maxQuanlity, String producer, String shortDescription,
			String description) {
		super();
		this.name = name;
		this.price = price;
		this.maxQuanlity = maxQuanlity;
		this.producer = producer;
		this.shortDescription = shortDescription;
		this.description = description;
	}
	
	public Product(String name, Integer price, Integer maxQuanlity, String producer, String shortDescription,
			String description, Set<Image> images) {
		super();
		this.name = name;
		this.price = price;
		this.maxQuanlity = maxQuanlity;
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

	public Integer getMaxQuanlity() {
		return maxQuanlity;
	}

	public void setMaxQuanlity(Integer maxQuanlity) {
		this.maxQuanlity = maxQuanlity;
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

	public Set<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(Set<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", maxQuanlity=" + maxQuanlity
				+ ", producer=" + producer + "]";
	}
	
	
}
