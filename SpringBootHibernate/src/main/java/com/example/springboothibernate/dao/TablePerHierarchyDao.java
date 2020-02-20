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

	public String addEmployee(Regular_Employee regularEmployee, Contract_Employee contractEmployee) {
		List<Employee> list = connection();
		Boolean idPresent = false;
		if (!list.isEmpty()) {
			for (Employee p : list) {
				if (employee.getId() == p.getId()) {
					idPresent = true;
					return "Employee Id is already present";
				}
			}
		}
			if (!idPresent) {
				Regular_Employee re = new Regular_Employee();
				re.setName(employee.getName());
				re.setBonus(employee.get);
				Contract_Employee ce = new Contract_Employee();
				ce.setName(employee.getName());
				session.save(p1);
				transaction.commit();
			}
		String msg = "successfully saved data";
		System.out.println(msg);
		factory.close();

		session.close();

		return msg;
	}

	List<Employee> connection() {
		factory = ProductsSessionFactory.getSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();
		Query<Employee> query = session.createQuery("FROM Employee");
		List<Employee> list = query.getResultList();
		return list;

	}

	public Employee fetchEmployee(int id) {
		List<Employee> list = connection();
		Employee employeesModel = new Employee();
		for (Employee e : list) {
			if (id == e.getId()) {
				System.out.println("***************");
			}
		}
		return employeesModel;
	}

	}

}
