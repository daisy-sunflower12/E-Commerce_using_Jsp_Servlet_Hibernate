package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.Product;
import com.entity.Purchase;
import com.util.HibUtil;

public class ProductDao {

	public int createProduct(Product product) {
		int rows = 0;

		try {
			Transaction tx = null;
			Session sess = HibUtil.getSessionfactory().openSession();
			tx = sess.beginTransaction();
			System.out.println("Saving product");
			product.setIsDeleted((byte) 1);
			rows = (int) sess.save(product);
			tx.commit();
			sess.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception " + e);
		}

		return rows;
	}

	public void updateProduct(Product product) {
		Product prod = new Product();

		try {
			Transaction tx = null;
			Session sess = HibUtil.getSessionfactory().openSession();
			tx = sess.beginTransaction();
			prod = getProductById(product.getId());
			prod.setProdName(product.getProdName());
			prod.setProdDesc(product.getProdDesc());
			prod.setProdSellPrice(product.getProdSellPrice());
			prod.setProdCostPrice(product.getProdCostPrice());
			prod.setStockUnit(product.getStockUnit());
			prod.setProdImg(product.getProdImg());
			prod.setPerson(product.getPerson());
			prod.setId(product.getId());

			sess.update(prod);
			System.out.println("Updating product");
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception " + e);
		}

	}

	public List<Product> viewProducts() {
		List<Product> list = new ArrayList<>();

		try {
			Transaction tx = null;
			Session sess = HibUtil.getSessionfactory().openSession();
			tx = sess.beginTransaction();

			Query q = sess.createQuery("from Product where isDeleted = 1");
			list = q.list();
			System.out.println(list);
			tx.commit();
			sess.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception " + e);
		}

		return list;
	}

	public Product getProductById(int id) {
		Product prod = new Product();

		try {
			Transaction tx = null;
			Session sess = HibUtil.getSessionfactory().openSession();
			tx = sess.beginTransaction();
			Query q = sess.createQuery("from Product where id=?1");
			q.setParameter(1, id);
			prod = (Product) q.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception " + e);
		}

		return prod;

	}

	public void deleteProduct(int id) {

		try {
			Transaction tx = null;
			Session sess = HibUtil.getSessionfactory().openSession();
			tx = sess.beginTransaction();
			Query q = sess.createQuery("delete from Product where id=?1");
			q.setInteger(1, id);
			q.executeUpdate();
			tx.commit();
			sess.clear();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception " + e);
		}

	}
}
