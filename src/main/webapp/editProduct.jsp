<%@page import="com.entity.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Form</title>
<jsp:include page="base.jsp"></jsp:include>
</head>
<body>
	<%
	Product p = (Product) request.getAttribute("product");
	%>
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-7 offset-md-2">
				<div class="card">
					<div class="card-body">
						<h2 class="text-center">Product Details</h2>
						<form action="EditProduct" method="post">
							<input type="hidden" name="id" value="<%= p.getId()%>">
							<div class="form-group">
								<label>Product Name: </label> <input type="text"
									class="form-control" name="prodName" value="<%=p.getProdName()%>" readOnly="readonly">
							</div>
							<div class="form-group mt-2">
								<label>Product Description: </label> <input type="text"
									class="form-control" name="prodDesc" value="<%= p.getProdDesc()%>">
							</div>
							<div class="form-group mt-2">
								<label>Product Image: </label> <input type="file"
									class="form-control" name="prodImg" value="<%= p.getProdImg()%> ">
							</div>
							
							<div class="form-group mt-2">
								<label>Product Sell Price: </label> <input type="number"
									class="form-control" name="prodSellPrice" value="<%= p.getProdSellPrice()%>">
							</div>
							<div class="form-group mt-2">
								<label>Product Cost Price: </label> <input type="number"
									class="form-control" name="prodCostPrice" value="<%= p.getProdCostPrice()%>">
							</div>
							<div class="form-group mt-2">
								<label>Stock Unit: </label> <input type="number"
									class="form-control" name="stockUnit" value="<%= p.getStockUnit()%>">
							</div>
							<div class="form-group mt-2">
								<label>Seller Id: </label> <input type="number"
									class="form-control" name="person" value="<%= p.getPerson().getId()%>">
							</div>
							<div class="text-center mt-3">
							<input type="submit" name="updateProduct" value="Update & Continue">
						</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>