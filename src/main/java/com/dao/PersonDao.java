package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.Person;
import com.entity.UserRole;
import com.util.HibUtil;

public class PersonDao {
	
	public int savePerson(Person person) {
		int rows = 0;
		try {
			Transaction tx = null;
			Session sess = HibUtil.getSessionfactory().openSession();
			//Person p = sess.get(Person.class, id);
			System.out.println("In dao");
			tx = sess.beginTransaction();
			rows = (int) sess.save(person);
			
			System.out.println(rows);
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception "+e.getMessage());
		}
		//return rows;
		return rows;
		
	}
	

	@SuppressWarnings("unchecked")
	public static List<UserRole> getRoles(UserRole role) {
		List<UserRole> list = new ArrayList<>();
		
		try {
			Transaction tx = null;
			Session sess = HibUtil.getSessionfactory().openSession();
			tx = sess.beginTransaction();
			Query<UserRole> q = sess.createQuery("from UserRole");
			list = q.list();
			System.out.println(list);
			tx.commit();
			sess.close();
		} catch (Exception e) {
			System.out.println("Exception "+e);
		}
		return list;	
	}
	
	public Person getPersonByEmail(String email) {
		Person p = null;
		try {
			Transaction tx = null;
			Session sess = HibUtil.getSessionfactory().openSession();
			tx = sess.beginTransaction();
			@SuppressWarnings("rawtypes")
			Query q = sess.createQuery("from Person where email='"+email+"'");
			/* Convenience method to return a single instance that matches the 
			 * query, or null if the query returns no results*/
			p = (Person)q.uniqueResult();
			System.out.println("Person: "+p);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception "+e);
		}		
		return p;		
	}
	
	public Person authenticatePerson(String email, String password) {
		Person person = getPersonByEmail(email);
		try {
			System.out.println("In auth");
			System.out.println(email);
			System.out.println(password);
			if(person != null && person.getEmail().equals(email) && person.getPassword().equals(password) && person.getUserRole().getId() == 1) {
				return person;
			}if(person != null && person.getEmail().equals(email) && person.getPassword().equals(password) && person.getUserRole().getId() == 2)
			return person;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception "+e);
		}
		
		return person;		
	}

}
