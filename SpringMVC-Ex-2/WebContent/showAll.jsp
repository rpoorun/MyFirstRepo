<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List Show All</title>
</head>
<body>
	<h1>Show All Product from Database</h1>

	<table>
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Price</th>
		</tr>

		<c:forEach var="product" items="${listAll}">

			<tr>
				<td>${product.productId}</td>
				<td>${product.prodName}</td>
				<td>${product.price}</td>
			</tr>
		</c:forEach>



	</table>
</body>
</html>