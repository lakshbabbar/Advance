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
 		<td>property Id</td>
 		<td>SQ_Area</td>
 		<td> Area Code</td>
 		<td>Loan Amount Taken</td>
 		<td>Apply loan</td>
 	</tr>
 	<tr>
 		<c:forEach var="loa" items="${loans}">
				<tr>

					<td>${loa.propertyid}</td>
					<td>${loa.property_sq}</td>
					<td>${loa.area_code}</td>
					<td>${loa.amount}</td>
					<td><a href="/applyloanExist/${loa.propertyid }/${loan.userid}">apply</a></td>

				</tr> 
			</c:forEach>
 		
 </table>
</div>


</body>
</html>