package com.example.springboothibernate.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.example.springboothibernate.config.ProductsSessionFactory;
import com.example.springboothibernate.model.ProductsModel;

@Component
public class StoreData {

	private SessionFactory factory;
	private Session session;
	private Transaction transaction;

	public String uploadData(ProductsModel productsModel) {
		List<ProductsModel> list = connection();
		Boolean idPresent = false;
		for (ProductsModel p : list) {
			if (productsModel.getProductId() == p.getProductId()) {
				idPresent = true;
				return "Product Id is already present";
			}
		}
		if (!idPresent) {
			ProductsModel p1 = new ProductsModel();
			p1.setProductId(productsModel.getProductId());
			p1.setProductName(productsModel.getProductName());
			p1.setProductAmount(productsModel.getProductAmount());
			session.save(p1);
			transaction.commit();
		}
		String msg = "successfully saved data for " + productsModel.getProductId();
		System.out.println(msg);
		factory.close();

		session.close();

		return msg;
	}

	List<ProductsModel> connection() {
		factory = ProductsSessionFactory.getSessionFactory();
		session = factory.openSession();
		transaction = session.beginTransaction();
		Query<ProductsModel> query = session.createQuery("FROM ProductsModel");
		List<ProductsModel> list = query.getResultList();
		return list;

	}

	public ProductsModel fetchData(int id) {
		List<ProductsModel> list = connection();
		ProductsModel productsModel = new ProductsModel();
		for (ProductsModel p : list) {
			if (id == p.getProductId()) {
				productsModel.setProductId(p.getProductId());
				productsModel.setProductName(p.getProductName());
				productsModel.setProductAmount(p.getProductAmount());
			}
		}
		return productsModel;
	}

}
