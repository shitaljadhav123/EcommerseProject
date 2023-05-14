package com.infosys.ecommerse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.ecommerse.model.Product;
import com.infosys.ecommerse.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductServiceI{

	@Autowired
	private ProductRepository productRepository;

	@Override
	public boolean saveProduct(Product prod) {
		Product product = productRepository.save(prod);
		if (product != null) {
			return true;
		} else {

			return false;
		}
	}

	@Override
	public List<Product> getAllProduct() {
	    List<Product> list = productRepository.findAll();
		return list;
	}

	@Override
	public Product getProductById(int pId) {
		Product findById = productRepository.findById(pId).get();
		return findById;
	}

	@Override
	public boolean updateProduct(Product prod) {
		Product product = productRepository.save(prod);
		
		if (product != null) {
			return true;
		} else {

			return false;
		}
		
	}

	@Override
	public String deleteById(int pId) {
		
		boolean existsById = productRepository.existsById(pId);
		if(existsById) {
	productRepository.deleteById(pId);
		return "product deleted successfully";
	}else {
		return "product not deleted";
}}

	@Override
	public String deleteAllRecords() {
		
		List<Product> findAll = productRepository.findAll();
		if(findAll !=null) {
			productRepository.deleteAll();
		return "records deleted successfully";
	}else {
		return "records  not deleted successfully";
		}
	}
}
