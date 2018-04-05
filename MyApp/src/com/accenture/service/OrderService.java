package com.accenture.service;

import java.util.List;

import com.accenture.entities.Order;
import com.accenture.exceptions.NegativeOrderIdException;
import com.accenture.exceptions.NegativeValueException;

public interface OrderService {
	public int addOrder(Order order) throws NegativeValueException;
	
	public List<Order> getAllOrder();
	
	public Order searchById(int orderId) throws NegativeOrderIdException;
	
	public int deleteOrder(int orderId) throws NegativeOrderIdException;
	
	public int changeShippingAddress(String shippingAddr, int orderId) throws NegativeOrderIdException;
}
