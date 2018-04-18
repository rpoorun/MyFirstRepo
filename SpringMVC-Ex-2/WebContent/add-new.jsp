<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Product</title>
</head>
<body>
	<h2>Add New Product</h2>

	<form name="addProduct" action="add-product.do">
		<table>
			<tr>
				<td>Product ID:</td>
				<td><input type="number" name="productId" /></td>
			</tr>
			<tr>
				<td>Product Name:</td>
				<td><input type="text" name="prodName" /></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><input type="number" name="price" /></td>
			</tr>
		</table>
		<input type="reset" />
		<input type="submit" value="Add Product"/>

	</form>
</body>
</html>