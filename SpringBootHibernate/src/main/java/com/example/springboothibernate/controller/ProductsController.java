package com.example.springboothibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboothibernate.model.ProductsModel;
import com.example.springboothibernate.service.StoreData;

@RestController
public class ProductsController {
	
	@Autowired
	StoreData storeData;
	
	
	/*Post employee data as below from any requester tool 
	 * URI: http://localhost:7072/uploadData
	 * Body: {"productId" : "101", "productName" : "Purse", "productAmount" : "2500"}
	 * Body Content type: application/json
	 * Method: POST
	 * */
	@PostMapping(value="/uploadData")
	public String uploadData(@RequestBody ProductsModel productsModel){
		System.out.println("Inside uploadData");
		String msg = storeData.uploadData(productsModel);
		return msg;
	}

	@GetMapping(value="/fetchData/id/{id}")
	public ProductsModel fetchData(@PathVariable int id){
		System.out.println("Inside fetchData");
		ProductsModel productsModel = storeData.fetchData(id);
		return productsModel;
	}
}
