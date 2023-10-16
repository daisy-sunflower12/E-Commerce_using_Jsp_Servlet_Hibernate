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

@WebServlet("/EditProduct")
public class EditProduct extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDao dao = new ProductDao();

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		if (req.getParameter("updateProduct") != null) {
			Product p = new Product();

			String id = req.getParameter("id");
			int pId = Integer.parseInt(id);
			p.setId(pId);

			p.setProdName(req.getParameter("prodName"));
			p.setProdDesc(req.getParameter("prodDesc"));

			String cost = req.getParameter("prodCostPrice");
			double pCost = Double.parseDouble(cost);
			p.setProdCostPrice(pCost);

			String sell = req.getParameter("prodSellPrice");
			double pSell = Double.parseDouble(sell);
			p.setProdSellPrice(pSell);

			String total = req.getParameter("stockUnit");
			int stock = Integer.parseInt(total);
			p.setStockUnit(stock);

			Person person = new Person();
			String perId = req.getParameter("person");
			int personId = Integer.parseInt(perId);
			person.setId(personId);
			p.setPerson(person);

			dao.updateProduct(p);
			out.print("Updated Product");
			resp.sendRedirect("ViewProduct");
		}
		
//		if (product > 0) {
//			out.print("Updated Product");
//			resp.sendRedirect("ViewProduct");
//		} else {
//			out.print("Unable to Update");
//			req.getRequestDispatcher("editProduct.jsp").include(req, resp);
//		}
	}

}
