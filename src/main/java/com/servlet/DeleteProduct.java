package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;
import com.entity.Product;

@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProductDao dao = new ProductDao();
		
		Product p = new Product();
		String id = req.getParameter("id");
		int pId = Integer.parseInt(id);
		
		p.setId(pId);
		
		dao.deleteProduct(pId);
		resp.sendRedirect("ViewProduct");
	}

}
