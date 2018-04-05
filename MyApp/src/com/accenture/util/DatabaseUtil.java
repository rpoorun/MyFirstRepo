package com.accenture.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

	private static String driverName = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/dborder";
	
	public static Connection getConnection(String userName, String password) {
		Connection con = null; 
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(URL, userName, password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	
	public static void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
