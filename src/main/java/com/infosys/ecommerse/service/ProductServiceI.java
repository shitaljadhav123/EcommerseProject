package com.infosys.ecommerse.service;

import java.util.List;

import com.infosys.ecommerse.model.Product;

public interface ProductServiceI {
	
public boolean saveProduct(Product prod);
	
	public List<Product> getAllProduct();
	
	public Product getProductById(int pId);
	
	public boolean updateProduct(Product prod);
	
	public String deleteById(int pId);
	
	public String deleteAllRecords();

	 
}
