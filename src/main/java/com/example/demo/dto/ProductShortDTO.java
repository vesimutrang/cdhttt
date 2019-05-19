package com.example.demo.dto;

public class ProductShortDTO {
	private Long id;
	private String name;
	private Integer price;
	private String producer;
	private String shortDescription;
	private String image;
	
	
	public ProductShortDTO() {
		super();
	}
	
	public ProductShortDTO(Long id, String name, Integer price, String producer, String shortDescription,
			String image) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.producer = producer;
		this.shortDescription = shortDescription;
		this.image = image;
	}
	
	public ProductShortDTO(Long id, String name, Integer price, String producer, String shortDescription) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.producer = producer;
		this.shortDescription = shortDescription;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
