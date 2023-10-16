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

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		HttpSession sess = req.getSession();
		PersonDao dao = new PersonDao();
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Person person = new Person();
		person.setEmail(email);
		person.setPassword(password);
		
		try {
			Person authPerson = dao.authenticatePerson(email, password);
			if(authPerson != null && authPerson.getEmail().equals(email) 
					&& authPerson.getPassword().equals(password)) {
				
				sess.setAttribute("auth", authPerson);
				resp.sendRedirect("home.jsp");
			}
		} catch (Exception e) {
			out.print("Person not saved");
			req.getRequestDispatcher("login.jsp").include(req, resp);
		}		
	}
	
	

}
