package com.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.entity.Person;
import com.entity.Product;
import com.entity.Purchase;
//import com.entity.Purchase;
import com.entity.UserRole;

public class HibUtil {

	private static SessionFactory factory;

	public static SessionFactory getSessionfactory() {

		if (factory == null) { // factory represents db

			try {
				Properties prop = new Properties();
				prop.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3307/prod_db");
				prop.setProperty("hibernate.connection.username", "root");
				prop.setProperty("hibernate.connection.password", "sushet");
				prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
				prop.setProperty("hibernate.hbm2ddl.auto", "update");
				prop.setProperty("hibernate.show_sql", "true");
				prop.setProperty("hibernate.format_sql", "true");

				Configuration cfg = new Configuration(); // creates Session F object here with given properties
				cfg.addAnnotatedClass(Person.class);
				cfg.addAnnotatedClass(UserRole.class);
				cfg.addAnnotatedClass(Product.class);
				cfg.addAnnotatedClass(Purchase.class);
				

				ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(prop).build();
				System.out.println("Hibernate Java Config serviceRegistry created");
				factory = cfg.buildSessionFactory(registry);

				return factory;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return factory;
	}

}
