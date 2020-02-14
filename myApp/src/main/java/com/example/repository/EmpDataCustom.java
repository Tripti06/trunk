package com.example.repository;

import java.util.List;

import com.example.model.EmpDetails;

public interface EmpDataCustom {
	
	List<EmpDetails> findByEqAbove(String salary);
	String findManager(String empName);
	int countEmployees(String managerName);
}
