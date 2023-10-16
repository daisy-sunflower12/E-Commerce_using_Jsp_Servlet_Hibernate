//package com.servlet;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//
//@WebServlet({"/", ""})
//public class HibServlet extends HttpServlet{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	try {
//		
//		resp.setContentType("text/html");
//		PrintWriter out = resp.getWriter();
//		Configuration cfg = new Configuration();
//		cfg.configure();
//		SessionFactory sf = cfg.buildSessionFactory();
//		out.print("In Hib servlet");
//		System.out.println("In servlet");
//		resp.sendRedirect("index.jsp");
//	} catch (Exception e) {
//		e.printStackTrace();
//		System.out.println("Oh My God" + e.getMessage());
//	}
//	}
//}
