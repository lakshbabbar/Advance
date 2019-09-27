<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>Account List</h1>
<table border="1">

			<th>Account Number</th>
			<th>Amount</th>
			<th>Account Type</th>
			<th>User Id</th>
			<c:forEach var="account" items="${listAccount}">
				<tr>

					<td>${account.accountnum}</td>
					<td>${account.amount}</td>
					<td>${account.accounttype}</td>
					<td>${account.userid}</td>
				</tr>
			</c:forEach>
		</table><br><br>
		<a href = "/">Go To Login Page</a>
					
</div> 
</body>
</html>