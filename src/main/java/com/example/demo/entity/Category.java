package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryId;
	@NotEmpty(message = "Vui lòng nhập tên")
	private String name;

	@JsonBackReference(value = "categoryChildrens")
	@OneToMany
	@JoinColumn(name = "parent_id")
	@OrderBy("sortorder ASC")
	private List<Category> categoryChildrens = new ArrayList<Category>();

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" }) // nếu Lazy thống bào mới tạo json được
	@ManyToOne(fetch = FetchType.LAZY) // optional = false runtime, nullable=false không cho column null csdl
	@JoinColumn(name = "parent_id")
	private Category categoryParent;

	private int sortorder;
	private int status;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Category> getCategoryChildrens() {
		return categoryChildrens;
	}

	public void setCategoryChildrens(List<Category> categoryChildrens) {
		this.categoryChildrens = categoryChildrens;
	}

	public Category getCategoryParent() {
		return categoryParent;
	}

	public void setCategoryParent(Category categoryParent) {
		this.categoryParent = categoryParent;
	}

	public int getSortorder() {
		return sortorder;
	}

	public void setSortorder(int sortorder) {
		this.sortorder = sortorder;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
