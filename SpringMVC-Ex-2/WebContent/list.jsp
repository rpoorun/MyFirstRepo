<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="com.accenture.entities.Product" %>
    <%@page import ="java.util.List" %>
    <%@page import ="java.util.ArrayList" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Page</title>
</head>
<body>
<h1>List of Products</h1>
<table>
<tr> 
	<th>Product Id</th>
	<th>Product Name</th>
	<th>Price</th>
</tr>

<c:forEach var="product" items="${list}">
<tr>
	<td>${product.productId}</td>
	<td>${product.prodName}</td>
	<td>${product.price}</td>
	
</tr>
</c:forEach>

</table>


</body>
</html>