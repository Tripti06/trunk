package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.EmpDetails;
import com.example.repository.EmpDataRepository;

@Service
public class MyAppService {

	@Autowired
	private EmpDataRepository repo;
	
	public Optional<EmpDetails> getSalary(String empId) {
		Optional<EmpDetails> findById = repo.findById(empId);
        return findById;
    }
	
	public List<EmpDetails> getByName(String empName) {
		System.out.println(empName);
		List<EmpDetails> findByName = repo.findByFirstName(empName);
        return findByName;
    }

	public List<EmpDetails> salaryEqAbove(String salary) {
		List<EmpDetails> findBySalary = repo.findByEqAbove(salary);
		System.out.println("Inside service class > salaryEqAbove " + findBySalary.toString());
		return findBySalary;
	}

	public String getManagerName(String empName) {
		System.out.println("Finding "+ empName+"'s Manager Name ");
		String managerName = repo.findManager(empName);
		return managerName;
	}

	public int getNoOfEmployees(String managerName) {
		System.out.println("Finding number of employees under"+ managerName);
		int empCount = repo.countEmployees(managerName);
		return empCount;
	}
}
