<%@page import="java.util.List"%>
<%@page import="com.dao.ProductDao"%>
<%@page import="com.entity.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buyer Page</title>
<jsp:include page="base.jsp"></jsp:include>
</head>
<body>
	<h2>Hello Buyer</h2>
	<% 
	
	ProductDao dao = new ProductDao();
	List<Product> prod = dao.viewProducts();
	request.setAttribute("list", prod);
	%>
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-7 offset-md-2">
				<div class="card">
					<div class="card-body">
						<h2 class="text-center">View Product</h2>
						<table class="table" border="1" width="100%">
							<thead>
								<tr>
									<th scope="col">Id</th>
									<th scope="col">Product Name</th>
									<th scope="col">Product Description</th>
									<th scope="col">Product Sell Price</th>
									<th scope="col">Product Cost Price</th>
									<th scope="col">Product Stock Price</th>
									<th scope="col">Add To Cart</th>
									<th scope="col">Buy Now</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="p">
									<tr>
										<th scope="row">${p.id}</th>
										<td>${p.prodName}</td>
										<td>${p.prodDesc}</td>
										<td>${p.prodSellPrice}</td>
										<td>${p.prodCostPrice}</td>
										<td>${p.stockUnit}</td>
										<td><a href="AddToCart?id=${p.id}">AddToCart</a></td>
										<td><a href="BuyNow?id=${p.id}">BuyNow</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>