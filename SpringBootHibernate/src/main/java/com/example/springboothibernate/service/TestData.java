package com.example.springboothibernate.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.springboothibernate.config.ProductsSessionFactory;
import com.example.springboothibernate.model.ProductsModel;

public class TestData {

	public void test() {
		System.out.println("Inside test data class");
		SessionFactory factory1 = ProductsSessionFactory.getSessionFactory();
		Session session1 = factory1.openSession();
		Transaction tran = session1.beginTransaction();

		ProductsModel p2 = new ProductsModel();
		p2.setProductId(106);
		p2.setProductName("Watch");
		p2.setProductAmount((long) 5000);

		session1.save(p2);
		tran.commit();
		System.out.println("successfully saved 2nd data");
		//factory1.close();
	}
}
