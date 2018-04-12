package com.accenture.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.accenture.beans.Table;
import com.accenture.entities.Customer;

public class CustomerDao {

	private JdbcTemplate jdbcTemplate;
	
	private String[] fields = Table.getField();
	
	public CustomerDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;

	}
	
	
	public List<Customer> selectAll(){
		List<Map<String, Object>> rsList = jdbcTemplate.queryForList(DBQuery.SELECT_ALL);

		List<Customer> custList = new ArrayList<>();
		for (Map<String, Object> map : rsList) {
			Customer cust = new Customer();
			cust.setCustomerId((int) map.get(fields[0]));
			cust.setCustomerName((String) map.get(fields[1]));
			cust.setAddr((String) map.get(fields[2]));
			cust.setCity((String) map.get(fields[3]));
			custList.add(cust);
		}

		return custList;
	}

	public Customer selectByName(String customerName) {
		Object[] args = { customerName };
		RowMapper<Customer> rowMapper = new CustomerRowMapper();

		Customer customer = jdbcTemplate.queryForObject(DBQuery.SELECT_NAME, args, rowMapper);

		return customer;
	}

	public Customer selectById(int customerId) {
		Object[] args = { customerId };
		RowMapper<Customer> rowMapper = new CustomerRowMapper();
		Customer customer = jdbcTemplate.queryForObject(DBQuery.SELECT_ID, args, rowMapper);

		return customer;
	}

	//
	public List<Customer> selectByCity(String city) {
		Object[] args = { city };
		List<Map<String, Object>> rsList = jdbcTemplate.queryForList(DBQuery.SELECT_CITY, args);

		List<Customer> custList = new ArrayList<>();
		for (Map<String, Object> map : rsList) {
			Customer cust = new Customer();
			cust.setCustomerId((int) map.get(fields[0]));
			cust.setCustomerName((String) map.get(fields[1]));
			cust.setAddr((String) map.get(fields[2]));
			cust.setCity((String) map.get(fields[3]));
			custList.add(cust);
		}

		return custList;
	}

	public int insertCustomer(int customerId, String customerName, String addr, String city) {

		Object[] args = { customerId, customerName, addr, city };
		int result = jdbcTemplate.update(DBQuery.INSERT, args);

		return result;
	}
	
	public int deleteCustomer(int customerId) {
		Object[] args = {customerId};
		int result = jdbcTemplate.update(DBQuery.DELETE_ID, args);
		
		return result;
	}

	
	public int updateAddrCity(String addr, String city, int customerId) {
		Object[] args = {addr, customerId};
		Object[] args1 = {city, customerId};
		int result = jdbcTemplate.update(DBQuery.UPDATE_ADDR, args);
		int result1 = jdbcTemplate.update(DBQuery.UPDATE_CITY, args1);
		
		if(result == result1) {
			return result;
		}
		else {
			return 0;
		}
		
		
	}
}
