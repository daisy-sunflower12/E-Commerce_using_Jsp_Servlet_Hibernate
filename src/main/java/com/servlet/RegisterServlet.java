package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.PersonDao;
import com.entity.Person;
import com.entity.UserRole;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PersonDao dao = new PersonDao();
	
	

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession sess = req.getSession();
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		if(req.getParameter("register") != null) {
			Person person = new Person();

			person.setFirstName(req.getParameter("firstName"));
			System.out.println(req.getParameter("firstName"));
			
			person.setLastName(req.getParameter("lastName"));
			System.out.println(req.getParameter("lastName"));
			
			person.setEmail(req.getParameter("email"));
			System.out.println(req.getParameter("email"));
			
			person.setPassword(req.getParameter("password"));
			System.out.println(req.getParameter("password"));
			
			person.setDob(req.getParameter("dob"));
			System.out.println(req.getParameter("dob"));

			String phone = req.getParameter("mobile");
			int mob = Integer.parseInt(phone);
			person.setMobile(mob);
			System.out.println(req.getParameter("mobile"));

			String bal = req.getParameter("balance");
			double balce = Double.parseDouble(bal);
			person.setBalance(balce);
			System.out.println(req.getParameter("balance"));

			UserRole ur = new UserRole();			
			String role = req.getParameter("userRole");
			System.out.println(role);
			int roleId = Integer.parseInt(role);			
			ur.setId(roleId);
			sess.setAttribute("role", person);
			person.setUserRole(ur);
			System.out.println(person.getUserRole());
			System.out.println(dao.savePerson(person));
			System.out.println(person);
			req.getRequestDispatcher("register.jsp").include(req, resp);
		}		
	}

}
