package com.accenture.dao;

import com.accenture.beans.Table;



public class DBQuery {
	
	
	private static String tableName = Table.getTableName();
	private static String[] field = Table.getField();
	
	
	public static final String SELECT_ALL = "SELECT * FROM "+tableName;
	
	public static final String SELECT_NAME = "SELECT * FROM "+tableName+" where "+field[1]+" = ?";
	
	public static final String SELECT_ID = "SELECT * FROM "+tableName+" where "+field[0]+" = ?";
	
	public static final String SELECT_CITY = "SELECT * FROM "+tableName+" where "+field[3]+" = ?";
	
	public static final String INSERT = "INSERT INTO "+tableName+" VALUES (?,?,?,?)";
	
	public static final String DELETE_ID = "DELETE FROM "+tableName+" WHERE "+field[0]+" = ?";
	
	public static final String UPDATE_ADDR = "UPDATE "+tableName+" SET "+field[2]+" = ? WHERE "+field[0]+" = ?";

	public static final String UPDATE_CITY = "UPDATE "+tableName+" SET "+field[3]+" = ? WHERE "+field[0]+" = ?";

}
