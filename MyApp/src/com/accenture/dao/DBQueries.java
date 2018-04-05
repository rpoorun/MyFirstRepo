package com.accenture.dao;

public interface DBQueries {
	
	public static final String INSERT_ORDER = "INSERT INTO ordertbl VALUES(?,?,?,?)";
	
	public static final String SELECT_ALL = "SELECT * FROM ordertbl";
	
	public static final String SEARCH_BY_ID = "SELECT * FROM ordertbl where orderid =?";
	
	public static final String DELETE_BY_ID = "DELETE FROM ordertbl where orderid = ?";
	
	public static final String UPDATE_SHIPPING_ADDR_BY_ID = "UPDATE ordertbl SET ShippingAddress = ? WHERE orderid = ?";
	

}
