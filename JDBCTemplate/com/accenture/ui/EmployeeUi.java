package com.accenture.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.beans.Employee;
import com.accenture.service.EmployeeService;

public class EmployeeUi {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beanConfig.xml");
		EmployeeService service = ctx.getBean("employeeService", EmployeeService.class);
		
		Employee emp = service.searchByEmpId(1);
		
		//System.out.println(emp);
		
		List<Employee> list = new ArrayList<Employee>();
		
		list = service.getEmpList();
		
		for(Employee emp1: list) {
			
			System.out.println(emp1);
		}
		
		System.out.println("-------------------------------------");
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the Employee ID: ");
		int empId = input.nextInt();
		System.out.print("Enter the Employee Name: ");
		String empName = input.next();
		System.out.print("Enter the Department: ");
		String dept = input.next();
		System.out.print("Enter the Salary: ");
		double salary = input.nextDouble();
		
		Employee employee = new Employee();
		employee.setEmpId(empId);
		employee.setEmpName(empName);
		employee.setDept(dept);
		employee.setSalary(salary);
		
		int result = service.addEmployee(employee);
		
		if (result == 1) {
			System.out.println("Employee added!");
		}
		else {
			
			System.out.println("Error: failed to add employee!");
		}
		
		
		input.close();
	}

}
