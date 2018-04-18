package com.accenture.services;

import java.util.List;

import com.accenture.dao.ProductDao;
import com.accenture.entities.Product;

public class ProductService {
	
	private ProductDao dao = new ProductDao();
	
	public List<Product> showAll(){
		
		return dao.selectAll();
	}
	
	public int deleteById(int productId) {
		
		return dao.deleteById(productId);
	}

	public Product searchById(int productId) {
		
		return dao.selectById(productId);
	}

	public int addProduct(int productId, String prodName, double price) {
		return dao.insertProduct(productId, prodName, price);
	}
}
