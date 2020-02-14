package com.example.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.EmpDetails;

@Transactional(readOnly = true)
@Repository
public class EmpDataCustomImpl implements EmpDataCustom {

	@PersistenceContext
    EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EmpDetails> findByEqAbove(String salary) {
		System.out.println("Inside repository with salary = " + salary);
		Query query = entityManager.createNativeQuery("SELECT * FROM TBL_EMPLOYEEDETAILS as em WHERE em.SALARY >= :salary", EmpDetails.class);
		query.setParameter("salary", salary);
		return query.getResultList();
	}

	@Override
	public String findManager(String empName) {
		System.out.println("Finding manager name for " + empName);
		Query query = entityManager.createNativeQuery("SELECT m.MANAGER_NAME FROM TBL_MANAGERDETAILS as m, TBL_EMPLOYEEDETAILS as e WHERE m.MANAGER_ID = e.MANAGER_ID_FK AND e.FIRST_NAME = :empName");
		query.setParameter("empName", empName);
		System.out.println(query.getSingleResult());
		return (String) query.getSingleResult();
	}

	@Override
	public int countEmployees(String managerName) {
		Query query = entityManager.createNativeQuery("SELECT * FROM TBL_EMPLOYEEDETAILS as e, TBL_MANAGERDETAILS as m WHERE m.MANAGER_ID = e.MANAGER_ID_FK AND m.MANAGER_NAME = :managerName");
		query.setParameter("managerName", managerName);
		System.out.println(query.getResultList().size());
		return query.getResultList().size();
	}

	
	
	
}
