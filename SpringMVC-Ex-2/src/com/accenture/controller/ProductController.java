package com.accenture.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.accenture.entities.Product;
import com.accenture.services.ProductService;

// this controller class contain all process layer and method for the Product Menu Page
@Controller
public class ProductController {

	private ProductService service = new ProductService();

	// this method reacts to the the Add Product button on the Product Menu Page
	@RequestMapping("/add-new")
	public String addProduct() {
		// the method return the name of the page.jsp containing the Add New Product
		// Form
		return "add-new";
	}

	@RequestMapping("/show-product")
	public String showProduct(Model model) {
		Product product = new Product();
		product.setProductId(101);
		product.setProdName("LG Microware");
		product.setPrice(10000);

		model.addAttribute("product", product);
		return "show";
	}

	@RequestMapping("/list-product")
	public String listProduct(Model model) {

		List<Product> list = new ArrayList<>();
		Product p1 = new Product();
		p1.setProductId(101);
		p1.setProdName("LG Microware");
		p1.setPrice(10000);
		list.add(p1);

		Product p2 = new Product();
		p2.setProductId(102);
		p2.setProdName("Samsung Microware");
		p2.setPrice(12000);
		list.add(p2);

		Product p3 = new Product();
		p3.setProductId(103);
		p3.setProdName("Trust Microware");
		p3.setPrice(9000);
		list.add(p3);

		model.addAttribute("list", list);
		return "list";
	}

	@RequestMapping("/show-all")
	public String showAllProduct(Model model) {

		List<Product> listAll = null;
		listAll = service.showAll();

		model.addAttribute("listAll", listAll);
		return "showAll";
	}

	@RequestMapping("/delete-by-id")
	public String deleteById(@RequestParam("deleteById") int productId, Model model) {
		// parse the product id to the service layer for the Delete function
		int result = service.deleteById(productId);
		String status;

		if (result == 1) {
			status = "Product ID: " + productId + " deleted from database!";
		} else {
			status = "Failed to delete product record!";
		}
		// parse status to the JSP page
		model.addAttribute("status", status);

		// return to the Product Menu page
		return "index";

	}

	// reacts to the Search button on the Product Menu page
	// captures the product id from the input text box
	@RequestMapping("/search-by-id")
	public String searchById(@RequestParam("searchById") int productId, Model model) {

		Product product = new Product();
		// parse the product id to the service layer for the Search function
		product = service.searchById(productId);

		// product returned from the SQL converted to string
		String status = product.toString();

		// parse status to the JSP page
		model.addAttribute("status", status);

		// returns to the Product Menu page
		return "index";

	}

	// this method reacts to the submit form on the Add New Product page
	@RequestMapping("/add-product")
	public String addProductForm(@RequestParam("productId") int productId, @RequestParam("prodName") String prodName,
			@RequestParam("price") double price, Model model) {
		// all the parameters read from the text field of the form is passed to the
		// service layer for addProduct Function

		int result = service.addProduct(productId, prodName, price);
		String status;

		if (result == 1) {
			status = "Product ID: " + productId + " added to database!";
		} else {
			status = "Failed to add product record!";
		}
		// the model stores the status of SQL query executed, and parse the status to
		// the JSP page

		model.addAttribute("status", status);
		// return to the Product Menu page
		return "index";
	}

}
