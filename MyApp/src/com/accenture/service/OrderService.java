package com.accenture.service;

import java.util.List;

import com.accenture.entities.Order;
import com.accenture.exceptions.NegativeValueException;

public interface OrderService {
	public int addOrder(Order order) throws NegativeValueException;
	
	public List<Order> getAllOrder();
	

}
