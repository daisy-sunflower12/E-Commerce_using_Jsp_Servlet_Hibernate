<%@page import="com.entity.Person"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="base.jsp"></jsp:include>
<meta charset="ISO-8859-1">
<title>Add Product</title>
</head>
<body>
<%
	Person p = (Person) session.getAttribute("auth");
	%>

	<%-- <h4>Welcome <%= p.getId() %></h4> --%>
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-7 offset-md-2">
				<div class="card">
					<div class="card-body">
						<h2 class="text-center">Add Product here</h2>
						<form action="addProduct" method="post">
							<div class="form-group">
								<label>Product Name:</label> <input class="form-control"
									type="text" name="prodName">
							</div>
							<div class="form-group">
								<label>Product Description:</label> <input class="form-control"
									type="text" name="prodDesc">
							</div>
							<div class="form-group">
								<label>Product Image:</label> <input class="form-control"
									type="file" name="prodImg">
							</div>
							<div class="form-group">
								<label>Product Sell Price:</label> <input class="form-control"
									type="number" name="prodSellPrice">
							</div>
							<div class="form-group">
								<label>Product Cost Price:</label> <input class="form-control"
									type="number" name="prodCostPrice">
							</div>
							<div class="form-group">
								<label>Stock Unit:</label> <input class="form-control"
									type="number" name="stockUnit">
							</div>
							<div class="form-group">
								<label>User Created:</label> <input class="form-control"
									type="number" name="person" value="<%=p.getId()%>" readonly>
							</div>
							<div class="text-center mt-3">
								<input type="submit" value="Add Product">
							</div>
						</form>
						<div class="text-center mt-3">
							<a href="ViewProduct">View Product</a>
						</div>
						<div class="text-center mt-3">
							<a href="home.jsp">Got To Home!!</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>