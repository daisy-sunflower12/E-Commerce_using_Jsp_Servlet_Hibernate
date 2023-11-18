package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ProductDao;
import com.entity.Person;
import com.entity.Product;
import com.entity.Purchase;

/**
 * Servlet implementation class AddToCart
 */
@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ProductDao prodDao = new ProductDao();

		resp.setContentType("text/html");
		try (PrintWriter out = resp.getWriter()) {
			out.print("add to cart servlet");

			List<Purchase> cartlist = new ArrayList<>();

			String id = req.getParameter("id");
			int prodId = Integer.parseInt(id);
			System.out.println(prodId);

			Purchase up = new Purchase();
			Product productById = prodDao.getProductById(prodId);
			System.out.println("Product: " + productById);
			productById.getPerson().getId();

			Person seller = new Person();
			seller.setId(productById.getPerson().getId());
			System.out.println(seller.getId());
			up.setProduct(productById);
//			System.out.println(up.getId());
			up.setTotalUnit(up.getTotalUnit());
			up.setSeller(seller);

			HttpSession sess = req.getSession();

			List<Purchase> cart_list = (List<Purchase>) sess.getAttribute("cart-list");
			if (cart_list == null) {
				cartlist.add(up);
				sess.setAttribute("cart-list", cartlist);
				resp.sendRedirect("buyer.jsp");
			} else {
				cartlist = cart_list;

				boolean exist = false;
				for (Purchase c : cart_list) {
					System.out.println("Prod Id: " + c.getProduct().getId());
					if (c.getProduct().getId() == productById.getId()) {
						exist = true;
						out.println(
								"<h3 style='color:crimson; text-align: center'>Item Already in Cart. <a href='cart.jsp'>GO to Cart Page</a></h3>");
					}
				}

				if (!exist) {
					cartlist.add(up);
					resp.sendRedirect("buyer.jsp");
				}

			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
