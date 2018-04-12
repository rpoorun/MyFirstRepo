package com.accenture.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.accenture.beans.Employee;

public class EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	public EmployeeDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Employee findById(int empId) {
		String sql = "Select * from employee where employeeId=?";
		Object[] params = { empId };
		RowMapper<Employee> rowMapper = new EmployerRowMapper();
		Employee emp = jdbcTemplate.queryForObject(sql, params, rowMapper);
		return emp;
	}

	public List<Employee> findAll() {
		String sql = "Select * from employee";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		// the list will generate a Map for each record, where the key is a string and
		// the value is an object storing the employee attributes(the key are the coln
		// name)

		List<Employee> empList = new ArrayList<>();
		for (Map<String, Object> map : list) {
			Employee emp = new Employee();
			// to cast the object to the data type
			emp.setEmpId((int) map.get("employeeId"));
			emp.setEmpName((String) map.get("employeeName"));
			emp.setDept((String) map.get("employeeDept"));
			emp.setSalary((double) map.get("salary"));
			empList.add(emp);

		}

		// another way of doing this fetch all record is by using the rowMapper function
		// to

		return empList;
	}

	public int insertRecord(Employee employee) {
		int result = 0;

		String sql = "INSERT INTO employee VALUES(?,?,?,?)";
		Object[] args = {employee.getEmpId(), employee.getEmpName(), employee.getDept(), employee.getSalary()};
		result = jdbcTemplate.update(sql, args);

		return result;
	}
}
