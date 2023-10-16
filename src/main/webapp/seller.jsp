<%@page import="com.entity.Person"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seller</title>
</head>
<body>
	<%
	Person p = (Person) session.getAttribute("auth");
	%>

	<h2>
		Hello
		<%=p.getUserRole().getName()%></h2>

	<h3>
		<a href="addProduct.jsp">Add Product</a><br>
		<a href="ViewProduct">View Product</a> <br>
		<a href="login.jsp">Logout!!</a>
	</h3>
</body>
</html>