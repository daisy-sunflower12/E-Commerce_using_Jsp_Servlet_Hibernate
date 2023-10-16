package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;
import com.entity.Product;

@WebServlet("/EditProductForm")
public class EditProductForm extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		ProductDao dao = new ProductDao();
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		Product p = new Product();
		String id = req.getParameter("id");
		int pId = Integer.parseInt(id);
		p.setId(pId);
		
		Product productById = dao.getProductById(pId);
		req.setAttribute("product", productById);
		req.getRequestDispatcher("editProduct.jsp").forward(req, resp);
		
		
		
	}

}
