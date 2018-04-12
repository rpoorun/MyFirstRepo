package com.accenture.entities;

public class Customer {
	
	private int customerId;
	private String customerName; 
	private String addr;
	private String city;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		
		String row = "|"+customerId+"\t\t|";
		
		if(customerName.length()<7) {
			row += customerName+"\t\t|";
		}
		else if(customerName.length()>=7 && customerName.length()<14) {
			row += customerName+"\t|";
		}
		
		else {
			row += customerName+"|";
		}
		
		if(addr.length()<8) {
			row += addr+"\t\t\t|";
		}
		else if(addr.length()>=8 && customerName.length()<16) {
			row += addr+"\t\t|";
		}
		
		else {
			row += addr+"|";
		}
		
		
		if(city.length() < 8) {
			row += city+"\t\t|";
		}
		else {
			row += city+"\t|";
		}
		
		return row;
	} 
	
	

}
