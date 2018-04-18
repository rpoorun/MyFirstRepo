package com.accenture.dao;

public class DBQuery {
	
	private static String tableName ="product";
	private static String col1 ="productid";
	private static String col2 ="productName";
	private static String col3 ="price";
	
	public static String SELECT_ALL = String.format("SELECT * FROM %s", tableName);
	
	public static String DELETE_BY_ID = String.format("DELETE FROM %s WHERE %s = ?", tableName, col1);
	
	public static String SELECT_BY_ID = String.format("SELECT * FROM %s WHERE %s = ?", tableName, col1);
	
	public static String INSERT = String.format("INSERT INTO %s VALUES(?,?,?)", tableName);
	
	
	
	
	

}
