package com.accenture.service;

import java.util.List;

import com.accenture.dao.OrderDao;
import com.accenture.dao.OrderDeoImpt;
import com.accenture.entities.Order;
import com.accenture.exceptions.NegativeOrderIdException;
import com.accenture.exceptions.NegativeValueException;

public class OrderServiceImpl implements OrderService {

	
	public OrderDao dao;
	
	public OrderServiceImpl() {
		dao = new OrderDeoImpt();
	}
	
	
	@Override
	public int addOrder(Order order) throws NegativeValueException {
		
		//data validation
		if(order.getCustId()<0 || order.getOrderAmount()<0 || order.getOrderId()<0) {
			throw new NegativeValueException("Negative values are not allowed");
		}
		// TODO Auto-generated method stub
		return dao.insertOrder(order);
	}

	@Override
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		return dao.showAllOrder();
	}
	
	
	public Order searchById(int orderId) throws NegativeOrderIdException {
		if (orderId < 0 ) {
			throw new NegativeOrderIdException("Order Id should be positive");
		}
			
		
		return dao.searchByid(orderId);
	}


	
	@Override
	public int deleteOrder(int orderId) throws NegativeOrderIdException {
		if (orderId < 0) {
			throw new NegativeOrderIdException("Order Id cannot be negative");
		}

		return dao.deleteById(orderId);
	}


	@Override
	public int changeShippingAddress(String shippingAddr, int orderId) throws NegativeOrderIdException {
		if (orderId<0) {
			throw new NegativeOrderIdException("Order ID cannot be negative");
		}
		
		return dao.updateAddrById(shippingAddr, orderId);
	}


	
	

}
