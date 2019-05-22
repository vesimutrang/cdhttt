package com.example.demo.model;

public class ApiResponseModel {
	private String errorMessage;
	private Object data;
	
	
	public ApiResponseModel() {
		super();
	}

	public ApiResponseModel(String errorMessage, Object data) {
		super();
		this.errorMessage = errorMessage;
		this.data = data;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
}
