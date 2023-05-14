package com.infosys.ecommerse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.ecommerse.model.Product;
import com.infosys.ecommerse.service.ProductServiceI;

@RestController
public class ProductController {
	
	@Autowired
	private ProductServiceI productServiceI;

	@PostMapping(value = "/saveProduct", consumes = "application/json")
	public ResponseEntity<String> saveProduct(@RequestBody Product prod) {

		boolean saveOrnot = productServiceI.saveProduct(prod);

		if (saveOrnot) {
			String msg = "Product Saved Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} else {
			String msg = "Product  not Saved Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping(value = "/getAllProduct", produces = "application/json")
	public ResponseEntity<List<Product>> getAllProduct() {

		List<Product> allProduct = productServiceI.getAllProduct();

		return new ResponseEntity<List<Product>>(allProduct, HttpStatus.OK);
	}

	@GetMapping(value = "getProductById/{sid}", produces = "application/json")
	public ResponseEntity<Product> getProductById(@PathVariable int pId) {

		Product product = productServiceI.getProductById(pId);
		return new ResponseEntity<Product>(product, HttpStatus.OK);

	}

	@PutMapping(value = "/updateProduct", consumes = "application/json")
	public ResponseEntity<String> updateProduct(@RequestBody Product prod) {

		boolean saveOrnot = productServiceI.updateProduct(prod);

		if (saveOrnot) {
			String msg = "Product Updated Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} else {
			String msg = "Product  not Updated Successfully";
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);

		}
	}

	@DeleteMapping("/deleteById/{pId}")
	public ResponseEntity<String> deleteById(@PathVariable int sid) {

		String deleteById = productServiceI.deleteById(sid);

		return new ResponseEntity<String>(deleteById, HttpStatus.OK);

	}

	@DeleteMapping("/delteAllRecords")
	public ResponseEntity<String> deleteAllRecords() {

		String deleteAllRecords = productServiceI.deleteAllRecords();

		return new ResponseEntity<String>(deleteAllRecords, HttpStatus.OK);

	}


}
