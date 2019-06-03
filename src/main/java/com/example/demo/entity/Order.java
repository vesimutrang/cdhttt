package com.example.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "order_item")
@EntityListeners(AuditingEntityListener.class)
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "generator")
	private Long id;
	
	@Column(length = 20)
	private String receiverPhoneNumber;
	
	@Column(nullable = false, columnDefinition = "nvarchar(300)")
	private String shippingAddress;
	
	@Column(nullable = true, columnDefinition = "nvarchar(200)")
	private String note;
	
	@Column(nullable = false)
	private Integer paymentMethod;
	
	@Column(nullable = true, length = 20)
	private String code;
	
	@Column()
	private boolean isGiftWrapping;
	
	@Column()
	private boolean issueAnInvoice;
	
	@Column(name="amount", nullable = false)
	private Integer amount;
	
    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private long createdDate;

	@OneToMany(mappedBy="order", cascade = CascadeType.ALL)
	private Set<OrderProduct> orderProducts;
	
	@ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
	@JsonIgnore
    private Account account;

	public Order() {
		super();
	}

	public Order(String receiverPhoneNumber, String shippingAddress, String note, Integer paymentMethod,
			String code, boolean isGiftWrapping, boolean issueAnInvoice, Integer amount) {
		this.receiverPhoneNumber = receiverPhoneNumber;
		this.shippingAddress = shippingAddress;
		this.note = note;
		this.paymentMethod = paymentMethod;
		this.code = code;
		this.isGiftWrapping = isGiftWrapping;
		this.issueAnInvoice = issueAnInvoice;
		this.amount = amount;
	}

	public Order(String receiverPhoneNumber, String shippingAddress, String note, Integer paymentMethod, String code,
			boolean isGiftWrapping, boolean issueAnInvoice, Integer amount, long createdDate,
			Set<OrderProduct> orderProducts) {
		super();
		this.receiverPhoneNumber = receiverPhoneNumber;
		this.shippingAddress = shippingAddress;
		this.note = note;
		this.paymentMethod = paymentMethod;
		this.code = code;
		this.isGiftWrapping = isGiftWrapping;
		this.issueAnInvoice = issueAnInvoice;
		this.amount = amount;
		this.createdDate = createdDate;
		this.orderProducts = orderProducts;
	}

	
	public Order(Long id, String receiverPhoneNumber, String shippingAddress, String note, Integer paymentMethod,
			String code, boolean isGiftWrapping, boolean issueAnInvoice, Integer amount, long createdDate,
			Set<OrderProduct> orderProducts) {
		super();
		this.id = id;
		this.receiverPhoneNumber = receiverPhoneNumber;
		this.shippingAddress = shippingAddress;
		this.note = note;
		this.paymentMethod = paymentMethod;
		this.code = code;
		this.isGiftWrapping = isGiftWrapping;
		this.issueAnInvoice = issueAnInvoice;
		this.amount = amount;
		this.createdDate = createdDate;
		this.orderProducts = orderProducts;
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

	public boolean isGiftWrapping() {
		return isGiftWrapping;
	}

	public void setGiftWrapping(boolean isGiftWrapping) {
		this.isGiftWrapping = isGiftWrapping;
	}

	public boolean isIssueAnInvoice() {
		return issueAnInvoice;
	}

	public void setIssueAnInvoice(boolean issueAnInvoice) {
		this.issueAnInvoice = issueAnInvoice;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public long getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(long createdDate) {
		this.createdDate = createdDate;
	}

	public Set<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(Set<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
