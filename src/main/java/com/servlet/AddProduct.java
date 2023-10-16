package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;
import com.entity.Person;
import com.entity.Product;

@WebServlet("/addProduct")
public class AddProduct extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDao dao = new ProductDao();
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		Product prod = new Product();
		prod.setProdName(req.getParameter("prodName"));
		System.out.println("Name: "+prod.getProdName());
		
		prod.setProdDesc(req.getParameter("prodDesc"));
		System.out.println("Desc: "+prod.getProdDesc());
		
		prod.setProdImg(req.getParameter("prodImg"));
		System.out.println("Image: "+prod.getProdImg());
		
		String pSell = req.getParameter("prodSellPrice");
		double sellPrice = Double.parseDouble(pSell);
		prod.setProdSellPrice(sellPrice);
		System.out.println("Sell Price: "+prod.getProdSellPrice());
		
		String pCost = req.getParameter("prodCostPrice");
		double costPrice = Double.parseDouble(pCost);
		prod.setProdCostPrice(costPrice);
		System.out.println("Cost Price: "+prod.getProdCostPrice());
		
		String pStock = req.getParameter("stockUnit");
		int stock = Integer.parseInt(pStock);
		prod.setStockUnit(stock);
		System.out.println("Stock: "+prod.getStockUnit());
		
		Person pr = new Person();
		String persId = req.getParameter("person");
		int pId = Integer.parseInt(persId);
		pr.setId(pId);
		
		prod.setPerson(pr);
		System.out.println("Seller Id"+prod.getPerson());
		
		int rows = dao.createProduct(prod);
		if(rows> 0) {
			out.print("product added");
			resp.sendRedirect("addProduct.jsp");
		}else {
			out.print("Product not added");
			req.getRequestDispatcher("addProduct.jsp");
		}
		
		
		
		
		
	}

}
