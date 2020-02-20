package com.example.springboothibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboothibernate.dao.TablePerHierarchyDao;
import com.example.springboothibernate.model.Contract_Employee;
import com.example.springboothibernate.model.Employee;
import com.example.springboothibernate.model.Regular_Employee;

@Service
public class TablePerHierarchyService {

	@Autowired
	TablePerHierarchyDao tablePerHierarchyDao;
	
	public Employee fetchEmployee(int id) {
		Employee productsModel = tablePerHierarchyDao.fetchEmployee(id);
		return productsModel;
	}

	public String addRegularEmployee(Regular_Employee regularEmployee) {
		String msg = tablePerHierarchyDao.addRegularEmployee(regularEmployee);
		return msg;
	}
	
	public String addContractEmployee(Contract_Employee contractEmployee) {
		String msg = tablePerHierarchyDao.addContractEmployee(contractEmployee);
		return msg;
	}

}
