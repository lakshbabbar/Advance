<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Management Screen</title>
</head>
<body>
	<div align="center">
		<h1>Employee List</h1>

		<table border="1">

			<th>EmpNum</th>
			<th>Name</th>
			<th>Department</th>
			<th>Designation</th>
			<th>Basic</th>

			<c:forEach var="emp" items="${EmployeeList}">
				<tr>

					<td>${emp.empno}</td>
					<td>${emp.name}</td>
					<td>${emp.dept}</td>
					<td>${emp.desig}</td>
					<td>${emp.basic}</td>
					
				</tr>
			</c:forEach>
		</table>
		<a href="displayJavaContractors">Display JavaContractors</a><br/>
		<a href="displayJavaContractorswherebasicgreater">Display JavaContractors where basic>50000</a><br/>
		<a href="displayJavaContractorswherenamestartswithB">Display JavaContractors where Name starts with b and Basic<25000</a>
	</div>
</body>
</html>