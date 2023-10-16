package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Person;
import com.entity.Product;
//import com.entity.Purchase;

@WebServlet("/BuyNow")
public class BuyNow extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Person auth = (Person) req.getSession().getAttribute("auth");
		//Purchase pr = new Purchase();
		Product prod = new Product();
		if(auth != null) {
			String id = req.getParameter("id");
			int prodId = Integer.parseInt(id);
			prod.setId(prodId);
			//pr.setId(prodId);
			
			
		}
	}
	
	

}
