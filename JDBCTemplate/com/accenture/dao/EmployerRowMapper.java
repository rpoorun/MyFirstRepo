package com.accenture.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accenture.beans.Employee;

public class EmployerRowMapper implements RowMapper<Employee> {
	
	public Employee mapRow(ResultSet rs, int num) throws SQLException {
		Employee emp = new Employee();
		emp.setEmpId(rs.getInt(1));
		emp.setEmpName(rs.getString(2));
		emp.setDept(rs.getString(3));
		emp.setSalary(rs.getDouble(4));
		return emp;

	}

	

}
