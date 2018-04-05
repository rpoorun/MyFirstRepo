package com.accenture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accenture.entities.Order;
import com.accenture.util.DatabaseUtil;

public class OrderDeoImpt implements OrderDao {

	@Override
	public int insertOrder(Order order) {
		Connection con = DatabaseUtil.getConnection("root", "root");
		
		int result = 0;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(DBQueries.INSERT_ORDER);
			pstmt.setInt(1, order.getOrderId());
			pstmt.setInt(2, order.getCustId());
			pstmt.setString(3, order.getShippingAddress());
			pstmt.setDouble(4, order.getOrderAmount());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		DatabaseUtil.closeConnection(con);
		return result;
	}

	@Override
	public List<Order> showAllOrder() {
		Connection con = DatabaseUtil.getConnection("root", "root");
		
		List<Order> list = new ArrayList<Order>();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(DBQueries.SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Order obj = new Order();
				obj.setCustId(rs.getInt(1));
				obj.setCustId(rs.getInt(2));
				obj.setShippingAddress(rs.getString(3));
				obj.setOrderAmount(rs.getDouble(4));
				list.add(obj);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		DatabaseUtil.closeConnection(con);
		return list;
	}


	@Override
	public Order searchByid(int orderId) {
		Order record = new Order();
		
		Connection con = DatabaseUtil.getConnection("root", "root");
		try {
			PreparedStatement pstmt = con.prepareStatement(DBQueries.SEARCH_BY_ID);
			
			pstmt.setInt(1, orderId);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				record.setOrderId(rs.getInt(1));
				record.setCustId(rs.getInt(2));
				record.setShippingAddress(rs.getString(3));
				record.setOrderAmount(rs.getDouble(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return record;
	}

	
	public int deleteById(int orderId) {
		int result = 0;
		
		Connection con = DatabaseUtil.getConnection("root", "root");
		try {
			PreparedStatement pstmt = con.prepareStatement(DBQueries.DELETE_BY_ID);
			pstmt.setInt(1,orderId);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return result;
	}

	
	
	public int updateAddrById(String shippingAddr, int orderId) {
		int result = 0;
		
		Connection con = DatabaseUtil.getConnection("root", "root");
		try {
			PreparedStatement pstmt = con.prepareStatement(DBQueries.UPDATE_SHIPPING_ADDR_BY_ID);
			pstmt.setString(1, shippingAddr);
			pstmt.setInt(2, orderId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

	}

	

	

