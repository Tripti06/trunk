package com.example.springboothibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.example.springboothibernate.config.ProductsSessionFactory;
import com.example.springboothibernate.model.Contract_Employee;
import com.example.springboothibernate.model.Employee;
import com.example.springboothibernate.model.Regular_Employee;

@Component
public class TablePerHierarchyDao {

	private SessionFactory factory;
	private Session session;
	private Transaction transaction;

	void connection() {
		factory = ProductsSessionFactory.getSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();
		
	}

	public Employee fetchEmployee(int id) {
		connection();
		Query<Employee> query = session.createQuery("FROM Employee");
		List<Employee> list = query.getResultList();
		Employee employeesModel = new Employee();
		for (Employee e : list) {
			if (id == e.getId()) {
				employeesModel.setId(id);
				employeesModel.setName(e.getName());
			}
		}
		return employeesModel;
	}

	public String addRegularEmployee(Regular_Employee regularEmployee) {
		connection();
		Regular_Employee re = new Regular_Employee();
		re.setName(regularEmployee.getName());
		re.setSalary(regularEmployee.getSalary());
		re.setBonus(regularEmployee.getBonus());
		
		session.save(re);
		transaction.commit();
		
		String msg = "Successfully added Regular Employee : " + re.getName();
		System.out.println(msg);

		//factory.close();
		session.close();

		return msg;
	}

	public String addContractEmployee(Contract_Employee contractEmployee) {
		connection();
		Contract_Employee ce = new Contract_Employee();
		ce.setName(contractEmployee.getName());
		ce.setPay_per_hour(contractEmployee.getPay_per_hour());
		ce.setContract_duration(contractEmployee.getContract_duration());
		
		session.save(ce);
		transaction.commit();
		
		String msg = "Successfully added Contract Employee : " + ce.getName();
		System.out.println(msg);

		//factory.close();
		session.close();

		return msg;
	}

}
