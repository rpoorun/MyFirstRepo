<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>INDEX PAGE</title>
</head>
<body>

	<h1>Product Menu Page</h1>

	<table>
		<tr>
			<td>Show all Product from Database:</td>
			<td><a href="show-all.do"><button>Show All Products</button></a></td>
		</tr>
		<tr>
			<td>Insert Product to Database:</td>
			<td><a href="add-new.do"><button>Add Product</button></a></td>
		</tr>
	</table>
	<form name="searchById" action="search-by-id.do">
		<table>
			<tr>
				<td><input type="text" name="searchById"
					placeholder="Search by ID" /></td>
				<td><input type="submit" value="Search"></td>
			</tr>
		</table>
	</form>

	<form name="deleteById" action="delete-by-id.do">
		<table>
			<tr>
				<td><input type="text" name="deleteById"
					placeholder="Delete by ID" /></td>
				<td><input type="submit" value="Delete"></td>
			</tr>
		</table>
	</form>




this list contain a logout 
	<ul style="list-style: none;">
		<li><a href="logout.do"><button>Log out</button></a></li>

	</ul>

	<!-- this div container will display the status returned from Product Controller with the status string -->
	<div>
		<h4>${status}</h4>

	</div>

</body>
</html>