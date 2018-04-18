package com.accenture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accenture.entities.Product;

public class ProductDao {
	
	public List<Product> selectAll(){
		
		List<Product> list = new ArrayList<>();
		Connection conn = DBConnectUtil.getConnection();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(DBQuery.SELECT_ALL);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Product p = new Product();
				p.setProductId(rs.getInt(1));
				p.setProdName(rs.getString(2));
				p.setPrice(rs.getDouble(3));
				
				list.add(p);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		return list;
	}
	
	
	public int deleteById(int productId) {
		int result = 0;

		Connection conn = DBConnectUtil.getConnection();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(DBQuery.DELETE_BY_ID);
			
			pstmt.setInt(1, productId);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DBConnectUtil.closeConnection(conn);
		return result;
	}


	public Product selectById(int productId) {
		Product product = new Product();
		
		Connection conn = DBConnectUtil.getConnection();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(DBQuery.SELECT_BY_ID);
			pstmt.setInt(1, productId);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				product.setProductId(rs.getInt(1));
				product.setProdName(rs.getString(2));
				product.setPrice(rs.getDouble(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return product;
	}


	public int insertProduct(int productId, String prodName, double price) {
		int result = 0; 
		
		Connection conn = DBConnectUtil.getConnection();
		
		try {
			PreparedStatement pstmt = conn.prepareStatement("");
			pstmt.setInt(1, productId);
			pstmt.setString(2, prodName);
			pstmt.setDouble(3, price);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

}
