<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
 <table border="1">
 	<tr>
 		<td>Product Name</td>
 		<td>weight</td>
 		<td>Loan Amount Taken</td>
 		<td>Apply loan</td>
 	</tr>
 	<tr>
 		<c:forEach var="products" items="${products}">
				<tr>

					<td>${products.producttype}</td>
					<td>${products.weight}</td>
					<td>${products.amount}</td>
					<td><a href="/applyloanExistProduct/${products.productid }/${product.userid}">apply</a></td>

				</tr> 
			</c:forEach>
 		
 </table>
</div>


</body>
</html>