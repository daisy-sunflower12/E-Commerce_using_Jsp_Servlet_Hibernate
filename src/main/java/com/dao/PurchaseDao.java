package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.Purchase;
import com.util.HibUtil;

public class PurchaseDao {
	
	public boolean insertOrder(Purchase purchase) {
		boolean result = false;
		
		try {
			Transaction tx = null;
			Session sess = HibUtil.getSessionfactory().openSession();
			tx = sess.beginTransaction();
			sess.save(purchase);
			result = true;
			tx.commit();
			sess.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception "+e);
		}		
		return result;
		
	}
	
	@SuppressWarnings("unchecked")
	public static List<Purchase> getAllCartProducts(List<Purchase> purchases) {
		List<Purchase> list = new ArrayList<>();

		try {
			Transaction tx = null;
			Session sess = HibUtil.getSessionfactory().openSession();
			tx = sess.beginTransaction();
			if (purchases.size() > 0) {
				for (Purchase c : purchases) {
					System.out.println(c.getProduct().getId());
					@SuppressWarnings("rawtypes")
					Query query = sess.createQuery("from Product where id=?1");
					query.setParameter(1, c.getProduct().getId());
					list = query.list();
				}
			}
			tx.commit();
			sess.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Eception " + e);
		}
		return list;
	}

}
