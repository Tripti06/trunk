package com.example.springboothibernate.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ProductsSessionFactory {

	private static SessionFactory factory;

	private ProductsSessionFactory() {
		System.out.println("Inside private constructor");
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		factory = meta.getSessionFactoryBuilder().build();

	}

	public static SessionFactory getSessionFactory() {
		System.out.println("Inside getSessionFactory");
		if (factory != null) {
			System.out.println("Returning existing factory object");
			return factory;
		} else {
			ProductsSessionFactory psf = new ProductsSessionFactory();
			return psf.factory;
		}
	}
}
