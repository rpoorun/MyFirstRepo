package com.accenture.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accenture.beans.Table;
import com.accenture.entities.Customer;
import com.accenture.services.CustomerService;

public class CustomerMainUI {

	static ApplicationContext ctx = new ClassPathXmlApplicationContext("beanConfig.xml");
	static CustomerService service = ctx.getBean("service", CustomerService.class);
	static Table tableCustomer = ctx.getBean("tableCustomer", Table.class);
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Please select following option to proceed:");
		optionMenu();
		// System.out.println(tableCustomer.getTableName());
		/*String[] test = Table.getField();
		for(int i = 0; i<4; i++) {
			
			System.out.println(test[i]);
		}*/
		
		boolean exit = false;
		do {
				System.out.print("Option -> ");
				String option = input.next();
		
				if (option.equalsIgnoreCase("name")) {
					searchByName();
				}
				
				else if(option.equalsIgnoreCase("show")) {
					showAll();
				}
		
				else if (option.equalsIgnoreCase("id")) {
					searchById();
				}
		
				else if (option.equalsIgnoreCase("city")) {
					searchByCity();
				}
		
				else if (option.equalsIgnoreCase("add")) {
					addCustomer();
				}
		
				else if (option.equalsIgnoreCase("delete")) {
					deleteCustomer();
				}
		
				else if (option.equalsIgnoreCase("update")) {
					updateCustomer();
				}
				else if (option.equalsIgnoreCase("exit")) {
					exit = true;
				}
				
				else if (option.equalsIgnoreCase("Help")) {
					optionMenu();
				}
				else {
					System.out.println("Error!");
				}
				
		}while(!exit);

		input.close();

	}//main()
	
	
	static void optionMenu() {
		System.out.println("Name: Search by Customer Name\nID: Search by Customer ID");
		System.out.println("City: Search by City \nShow: Display all records");
		System.out.println("Add: Add a new customer \nDelete: Remove a Customer");
		System.out.println("Update: Edit the Address and City of Customer");
		System.out.println("Exit: Terminate program");
	}
	
	static void showAll() {
		List<Customer> custList = new ArrayList<>();
		custList = service.showAll();
		
		System.out.println("+---------------+---------------+-----------------------+---------------+");
		System.out.println("|CustomerId\t|CustomerName\t|Address\t\t|City\t\t|");
		System.out.println("+---------------+---------------+-----------------------+---------------+");
		for (Customer cust : custList) {
			
			System.out.println(cust.toString());
		}
		System.out.println("+---------------+---------------+-----------------------+---------------+");
	}

	static void searchByName() {

		System.out.print("Search Name -> ");
		String customerName = input.next();
		Customer cust = new Customer();
		cust = service.searchByName(customerName);
		System.out.println("+---------------+---------------+-----------------------+---------------+");
		System.out.println("|CustomerId\t|CustomerName\t|Address\t\t|City\t\t|");
		System.out.println("+---------------+---------------+-----------------------+---------------+");
		System.out.println(cust.toString());
		System.out.println("+---------------+---------------+-----------------------+---------------+");
	}

	static void searchById() {
		System.out.print("Search ID -> ");
		int customerId = input.nextInt();
		Customer cust = new Customer();
		cust = service.searchById(customerId);
		System.out.println("+---------------+---------------+-----------------------+---------------+");
		System.out.println("|CustomerId\t|CustomerName\t|Address\t\t|City\t\t|");
		System.out.println("+---------------+---------------+-----------------------+---------------+");
		System.out.println(cust.toString());
		System.out.println("+---------------+---------------+-----------------------+---------------+");
	}

	static void searchByCity() {
		System.out.print("Search City -> ");
		String city = input.next();
		List<Customer> custList = new ArrayList<>();
		custList = service.searchByCity(city);
		
		System.out.println("+---------------+---------------+-----------------------+---------------+");
		System.out.println("|CustomerId\t|CustomerName\t|Address\t\t|City\t\t|");
		System.out.println("+---------------+---------------+-----------------------+---------------+");
		for (Customer cust : custList) {
			
			System.out.println(cust.toString());
		}
		System.out.println("+---------------+---------------+-----------------------+---------------+");
	}

	static void addCustomer() {
		System.out.print("Insert Customer ID: ");
		int customerId = input.nextInt();
		System.out.print("Insert Customer Name: ");
		String customerName = input.next();
		System.out.print("Insert Address: ");
		String addr = input.next();
		System.out.print("Insert City: ");
		String city = input.next();

		int result = service.addCustomer(customerId, customerName, addr, city);

		if (result == 1) {
			System.out.println("Customer added!");
		} else {
			System.out.println("Failed to add new Customer!");
		}
		
		System.out.println("-------------------------------------------------------");

	}

	static void deleteCustomer() {
		System.out.println("Delete Customer by ID:");
		System.out.print("ID -> ");
		int customerId = input.nextInt();
		int result = service.deleteCustomer(customerId);
		if (result == 1) {
			System.out.println("Customer deleted!");
		}

		else {
			System.out.println("Could not perform delete!");
		}
		System.out.println("-------------------------------------------------------");
	}

	static void updateCustomer() {
		System.out.println("Update Customer details:");
		System.out.print("Customer ID -> ");
		int customerId = input.nextInt();
		System.out.print("New Address ->");
		String addr = input.next();
		System.out.print("New City ->");
		String city = input.next();
		int result = service.updateAddrAndCity(addr, city, customerId);

		if (result == 1) {

			System.out.println("Customer profile updated!");
		} else {
			System.out.println("Could not perform update!");
		}
		System.out.println("-------------------------------------------------------");
	}
}
