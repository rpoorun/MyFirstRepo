package com.accenture.dao;

import java.util.List;

import com.accenture.entities.Order;

public interface OrderDao {

	public int insertOrder(Order order);
	
	public List<Order> showAllOrder();
	
	public Order searchByid(int orderId);
	
	public int deleteById(int orderId);
	
	public int updateAddrById (String shippingAddr, int orderId);
	
}
