<%@page import="com.entity.Person"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<%
	Person p = (Person) session.getAttribute("auth");
	%>

	 <h2>
		Welcome
		<%=p.getUserRole().getName()%></h2>

	<c:set value="<%=p.getUserRole().getName()%>" var="role"></c:set> 
	<c:choose>
		<c:when test="${role == 'BUYER'}">
			<a href="buyer.jsp">Go To Buyer</a>
		</c:when>
		<c:when test="${role == 'SELLER'}">
			<a href="seller.jsp">Go To Seller</a>
		</c:when>
		<c:otherwise>
			<a href="login.jsp">Login/Register</a>
		</c:otherwise>

	</c:choose>

</body>
</html>