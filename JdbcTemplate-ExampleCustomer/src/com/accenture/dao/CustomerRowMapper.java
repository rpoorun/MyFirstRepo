package com.accenture.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accenture.entities.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
		Customer cust = new Customer();
		cust.setCustomerId(rs.getInt(1));
		cust.setCustomerName(rs.getString(2));
		cust.setAddr(rs.getString(3));
		cust.setCity(rs.getString(4));
		return cust;
		
	}

}
