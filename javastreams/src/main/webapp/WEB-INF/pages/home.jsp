<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div align="center">
<form:form action="filter" method="post" modelAttribute="searchemployee">
		<h1>Employee List</h1>
		<br/><br/>
		Employee  Name :
		<form:input path="empname"/><br><br>
		EMP Band :
		<form:input path="band"/><br><br>
		<input type="submit" value="Search"/>
			</form:form>
		<h3>
		Number of Employees : "${listEmployee.size()}"
		</h3>
		<table border="1">

			<th>EmpNo</th>
			<th>EmpName</th>
			<th>Salary</th>
			<th>band</th>
			<th>Date Of Join</th>

			<c:forEach var="employee" items="${listEmployee}">
				<tr>

					<td>${employee.empno}</td>
					<td>${employee.empname}</td>
					<td>${employee.salary}</td>
					<td>${employee.band}</td>
					<td>${employee.dateofjoin}</td>

				</tr>
			</c:forEach>
		</table>
	
	</div>

</body>
</html>