package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;
import com.entity.Product;

@WebServlet("/ViewProduct")
public class ViewProduct extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProductDao dao = new ProductDao();
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		List<Product> viewProducts = dao.viewProducts();
		req.setAttribute("products", viewProducts);
		req.getRequestDispatcher("viewProducts.jsp").forward(req, resp);
		
	}
	

}
