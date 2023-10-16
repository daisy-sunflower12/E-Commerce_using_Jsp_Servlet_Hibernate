package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

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

}
