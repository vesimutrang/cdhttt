package com.example.demo.model;

import java.util.List;


public class OrderCreation {
	private Long customerId;
	private String receiverPhoneNumber;
	private String shippingAddress;
	private String note;
	private Integer paymentMethod;
	private String code;
	private Boolean isGiftWrapping;
	private Boolean issueAnInvoice;
	private List<Item> items;
	private Integer amount;
	
	
	public OrderCreation() {
		super();
	}

	public OrderCreation(Long customerId, String receiverPhoneNumber, String shippingAddress, String note,
			Integer paymentMethod, String code, Boolean isGiftWrapping, Boolean issueAnInvoice, List<Item> items,
			Integer amount) {
		super();
		this.customerId = customerId;
		this.receiverPhoneNumber = receiverPhoneNumber;
		this.shippingAddress = shippingAddress;
		this.note = note;
		this.paymentMethod = paymentMethod;
		this.code = code;
		this.isGiftWrapping = isGiftWrapping;
		this.issueAnInvoice = issueAnInvoice;
		this.items = items;
		this.amount = amount;
	}
	
	public OrderCreation(Long customerId, String receiverPhoneNumber, String shippingAddress, String note,
			Integer paymentMethod, String code, Boolean isGiftWrapping, Boolean issueAnInvoice, List<Item> items) {
		super();
		this.customerId = customerId;
		this.receiverPhoneNumber = receiverPhoneNumber;
		this.shippingAddress = shippingAddress;
		this.note = note;
		this.paymentMethod = paymentMethod;
		this.code = code;
		this.isGiftWrapping = isGiftWrapping;
		this.issueAnInvoice = issueAnInvoice;
		this.items = items;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getReceiverPhoneNumber() {
		return receiverPhoneNumber;
	}
	public void setReceiverPhoneNumber(String receiverPhoneNumber) {
		this.receiverPhoneNumber = receiverPhoneNumber;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(Integer paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Boolean getIsGiftWrapping() {
		return isGiftWrapping;
	}
	public void setIsGiftWrapping(Boolean isGiftWrapping) {
		this.isGiftWrapping = isGiftWrapping;
	}
	public Boolean getIssueAnInvoice() {
		return issueAnInvoice;
	}
	public void setIssueAnInvoice(Boolean issueAnInvoice) {
		this.issueAnInvoice = issueAnInvoice;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
}