package com.accenture.services;

import java.util.List;

import com.accenture.dao.CustomerDao;
import com.accenture.entities.Customer;

public class CustomerService {
	
	private CustomerDao dao; 
	
		
	public CustomerService(CustomerDao dao) {
		this.dao = dao;
	}
	
	public List<Customer> showAll() {
		
		return dao.selectAll();
		
	}
	
	public Customer searchByName(String customerName) {
		
		return dao.selectByName(customerName);
	}
	
	public Customer searchById(int customerId) {
		return dao.selectById(customerId);
	}
	
	public List<Customer> searchByCity(String city){
		
		return dao.selectByCity(city);
	}
	
	public int addCustomer(int customerId, String customerName, String addr, String city) {
		
		return dao.insertCustomer(customerId, customerName, addr, city);
	}
	
	public int deleteCustomer(int customerId) {
		
		return dao.deleteCustomer(customerId);
	}
	
	public int updateAddrAndCity(String addr, String city, int customerId) {
		
		return dao.updateAddrCity(addr, city, customerId);
	}
}
