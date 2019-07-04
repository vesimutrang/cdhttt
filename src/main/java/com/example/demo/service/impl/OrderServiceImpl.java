package com.example.demo.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderProduct;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.model.Item;
import com.example.demo.model.OrderCreation;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.OrderService;

import javassist.NotFoundException;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	OrderRepository orderRepository;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean createOrder(OrderCreation orderModel) throws NotFoundException {
		// can using Spring security to get credential 
		User user = userRepository.getOne(orderModel.getCustomerId());
		if (user == null) {
			throw new NotFoundException(String.format("Cannot found user id = %s", user.getUserId()));
		}
		Order order = new Order(orderModel.getReceiverPhoneNumber(),
				orderModel.getShippingAddress(), orderModel.getNote(),
				orderModel.getPaymentMethod(), orderModel.getCode(),
				orderModel.getIsGiftWrapping(), orderModel.getIssueAnInvoice(),
				orderModel.getAmount());
		
		Set<OrderProduct> orderProducts = new HashSet<>();
		
		for (Item item : orderModel.getItems()) {
			Product product = productRepository.getOne(item.getId());
			if (product == null) {
				throw new NotFoundException(String.format("Cannot found product id = %s", item.getId()));
			}
			if (product.getMaxQuanlity() < item.getQuantity()) {
				throw new NotFoundException(String.format("The quanlity is not enough %s < %s", product.getMaxQuanlity(),item.getQuantity()));
			}
			OrderProduct orderProduct = new OrderProduct(item.getQuantity(), product, order);
			orderProduct.setOrder(order);
			orderProducts.add(orderProduct);
		}
		order.setOrderProducts(orderProducts);
		order.setUser(user);
		orderRepository.save(order);
		return true;
	}

}
