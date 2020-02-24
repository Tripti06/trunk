package com.example.springboothibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboothibernate.model.Contract_Employee;
import com.example.springboothibernate.model.Employee;
import com.example.springboothibernate.model.Regular_Employee;
import com.example.springboothibernate.service.TablePerHierarchyService;

@RestController
public class TablePerHierarchyController {

	@Autowired
	TablePerHierarchyService tablePerHierarchyService;

	/*
	 * Post employee data as below from any requester tool
	 * 
	 * URI : http://localhost:7072/addRegularEmployee 
	 * Body for addRegularEmployee :  {"name" : "Tripti", "salary" : "50000", "bonus" : "5000"}
	 * 
	 * OR
	 * 
	 * URI: http://localhost:7072/addContractEmployee 
	 * Body for contractEmployee : {"name" : "Tripti", "pay_per_hour":"1000", "contract_duration":"15 hours"} 
	 * 
	 * Body Content type: application/json 
	 * 
	 * Method: POST
	 */
	@PostMapping(value = "/addRegularEmployee")
	public String addRegularEmployee(@RequestBody Regular_Employee regularEmployee) {
		System.out.println("Inside addRegularEmployee");
		String msg = tablePerHierarchyService.addRegularEmployee(regularEmployee);
		return msg;
	}

	@PostMapping(value = "/addContractEmployee")
	public String addContractEmployee(@RequestBody Contract_Employee contractEmployee) {
		System.out.println("Inside addContractEmployee");
		String msg = tablePerHierarchyService.addContractEmployee(contractEmployee);
		return msg;
	}

	@GetMapping(value = "/fetchEmployee/id/{id}")
	public Employee fetchEmployee(@PathVariable int id) {
		System.out.println("Inside fetchData");
		Employee employee = tablePerHierarchyService.fetchEmployee(id);
		return employee;
	}
}
