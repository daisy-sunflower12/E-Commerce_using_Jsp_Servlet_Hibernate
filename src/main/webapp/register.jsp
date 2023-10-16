<%@page import="java.util.List"%>
<%@page import="com.entity.Person"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="base.jsp"></jsp:include>
<title>Insert title here</title>
</head>
<body>
<%@page import="com.entity.*, com.dao.PersonDao" %>
<% UserRole ur = new UserRole();
List<UserRole> roles = PersonDao.getRoles(ur);

Person person = (Person)session.getAttribute("person");
%>
<%= roles%>
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-7 offset-md-2">
				<div class="card">
					<div class="card-body">
						<h2 class="text-center">Register here</h2>
						<form action="Register" method="post">
							<div class="form-group">
								<label>First Name:</label> <input type="text" name="firstName"
									class="form-control" />
							</div>

							<div class="form-group mt-2">
								<label>Last Name:</label> <input type="text" name="lastName"
									class="form-control" />
							</div>
							<div class="form-group mt-2">
								<label>Email:</label> <input type="email" name="email"
									class="form-control" />
							</div>
							<div class="form-group">
								<label>Password:</label> <input type="password" name="password"
									class="form-control" />
							</div>
							<div class="form-group mt-2">
								<label>Mobile:</label> <input type="text" max="10" name="mobile"
									class="form-control" />
							</div>
							<div class="form-group mt-2">
								<label>DoB:</label> <input type="date" name="dob"
									class="form-control" />
							</div>
							<div class="form-group mt-2">
								<label>Balance:</label> <input type="number" name="balance"
									class="form-control" />
							</div>
							<%-- <h2><%=roles %></h2> --%>
							<div class="form-group mt-2">
								<label>Role Type :</label> <select class="form-select"
									name="userRole">
									<c:out value="${roles}"></c:out>
									<c:forEach items="<%=roles%>" var="r">
										<option value="${r.id}">${r.name}</option>
										<!-- <option value="2">Seller</option> -->
									</c:forEach>
								</select>
							</div>
							<div class="text-center mt-3">
								<input type="submit" name="register" value="Register">
								<a href="login.jsp">Go To Home</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>