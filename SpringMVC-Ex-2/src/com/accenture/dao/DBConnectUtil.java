package com.accenture.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectUtil {
	
	private static String driverName = "com.mysql.jdbc.Driver";
	private static  String url = "jdbc:mysql://localhost:3306/dbjava";
	private static String user = "root";
	private static String password = "root";
	
	public static Connection getConnection () {
		Connection conn = null; 
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, password);
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return conn;
	}
	
	
	public static void closeConnection (Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
