package com.accenture.ui;

import java.util.ArrayList;
import java.util.List;

import com.accenture.entities.Order;
import com.accenture.exceptions.NegativeOrderIdException;
import com.accenture.exceptions.NegativeValueException;
import com.accenture.service.OrderService;
import com.accenture.service.OrderServiceImpl;

public class MainUI {
	
 public static void main(String[] args) {
	OrderService service = new OrderServiceImpl();
	Order order = new Order();
	
	order.setOrderId(101);
	order.setCustId(101);
	order.setShippingAddress("Mahebourg");
	order.setOrderAmount(1900);
	
	try {
		service.addOrder(order);
	} catch (NegativeValueException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	List<Order> records = new ArrayList<>();
	records= service.getAllOrder();
	
	for(Order ord : records) {
		System.out.println(ord.getOrderId()+" "+ord.getCustId()+" "+ord.getShippingAddress()+" "+ord.getOrderAmount());
	}
	
	
	/*int orderId = 101;
	
	try {
		order = service.searchById(orderId);
	} catch (NegativeOrderIdException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println(order.getOrderId()+" "+order.getCustId()+" "+order.getShippingAddress()+ " "+order.getOrderAmount());
	*/
	
	
	/*int orderId = 101;
	
	try {
		 service.deleteOrder(orderId);
	} catch (NegativeOrderIdException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	List<Order> records = new ArrayList<>();
	records= service.getAllOrder();
	
	for(Order ord : records) {
		System.out.println(ord.getOrderId()+" "+ord.getCustId()+" "+ord.getShippingAddress()+" "+ord.getOrderAmount());
	}*/
	
	int orderId =101;
	
	System.out.println("Changed the shipping address or order id 101 to 'Flacq'");
	
	try {
		service.changeShippingAddress("Flacq", orderId);
	} catch (NegativeOrderIdException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	List<Order> record = new ArrayList<>();
	record= service.getAllOrder();
	
	for(Order ord : record) {
		System.out.println(ord.getOrderId()+" "+ord.getCustId()+" "+ord.getShippingAddress()+" "+ord.getOrderAmount());
	}
	
}

}
