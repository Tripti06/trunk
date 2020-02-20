package com.example.springboothibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboothibernate.model.Employee;
import com.example.springboothibernate.model.Regular_Employee;
import com.example.springboothibernate.service.TablePerHierarchyService;

@RestController
public class TablePerHierarchyController {

	@Autowired
	TablePerHierarchyService tablePerHierarchyService;
	
	
	/*Post employee data as below from any requester tool 
	 * URI: http://localhost:7071/uploadData
	 * Body: {"name" : "Tripti", "salary" : "50000", "bonus" : "5000"}
	 * OR
	 * {"name" : "Tripti", "pay_per_hour":"1000", "contract_duration":"15 hours"}
	 * Body Content type: application/json
	 * Method: POST
	 * */
	@PostMapping(value="/addEmployee")
	public String addEmployee(@RequestBody Regular_Employee regularEmployee){
		System.out.println("Inside uploadData");
		String msg = tablePerHierarchyService.addEmployee(regularEmployee);
		return msg;
	}

	@GetMapping(value="/fetchEmployee/id/{id}")
	public Employee fetchEmployee(@PathVariable int id){
		System.out.println("Inside fetchData");
		Employee employee = tablePerHierarchyService.fetchEmployee(id);
		return employee;
	}
}
