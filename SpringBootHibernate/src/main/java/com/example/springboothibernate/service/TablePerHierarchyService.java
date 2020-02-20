package com.example.springboothibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboothibernate.dao.TablePerHierarchyDao;
import com.example.springboothibernate.model.Employee;

@Service
public class TablePerHierarchyService {

	@Autowired
	TablePerHierarchyDao tablePerHierarchyDao;
	
	public String addEmployee(Employee employee) {
		String msg = tablePerHierarchyDao.addEmployee(employee);
		return msg;
	}

	public Employee fetchEmployee(int id) {
		Employee productsModel = tablePerHierarchyDao.fetchEmployee(id);
		return productsModel;
	}

}
