package com.accenture.dao;

public interface DBQueries {
	
	public static final String INSERT_ORDER = "INSERT INTO ordertbl VALUES(?,?,?,?)";
	
	public static final String SELECT_ALL = "SELECT * FROM ordertbl";

}
