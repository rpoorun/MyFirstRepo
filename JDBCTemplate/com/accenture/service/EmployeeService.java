package com.accenture.service;

import java.util.List;

import com.accenture.beans.Employee;
import com.accenture.dao.EmployeeDao;

public class EmployeeService {
	
	private EmployeeDao employeeDao;
	
	public EmployeeService(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	public Employee searchByEmpId(int empId) {
		return employeeDao.findById(empId);
	}
	
	
	public List<Employee> getEmpList(){
		return employeeDao.findAll();
	}
	
	
	public int addEmployee(Employee employee) {
		
		return employeeDao.insertRecord(employee);
	}
}
