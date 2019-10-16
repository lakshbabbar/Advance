<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<script type="text/javascript">
	function fun() {
		var url = document.getElementById('list').value;
		if (url != 'none') {
			window.location = url;
		}
	}
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Management Screen</title>
</head>
<body>
	<div align="center">
		<h1>Employee List</h1>
		<%
			int size = (int) request.getAttribute("totalrecords");
			int pagesize = (int) request.getAttribute("pagesize");
			int loop;
			if (size % pagesize > 0) {
				loop = size % pagesize + 1;
			} else {
				loop = size / pagesize;
			}
		%>
		<form method="post">
			<select name="list" id="list">
				<%
				int n =0;
				if(request.getAttribute("pageno") != null) {
					n = ((Integer)request.getAttribute("pageno")).intValue();
					}
				out.println("<option value='/displayAll/page/" + n + "'>Page " + (n + 1) + "</option>"); 
					for (int i = 0; i < loop; i++) {
						out.println("<option value='/displayAll/page/" + i + "'>Page " + (i + 1) + "</option>");
					}
				
				%>
			</select> <input type=button value="Go" onclick="fun()" />
			

		</form>
		</br>
		</br>

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
		<!-- 	<a href="displayJavaContractors">Display JavaContractors</a><br/>
		<a href="displayJavaContractorswherebasicgreater">Display JavaContractors where basic>50000</a><br/>
		<a href="displayJavaContractorswherenamestartswithB">Display JavaContractors where Name starts with b and Basic lower than 25000</a><br/>
		<a href="displayAllSortBYDesig">display All Sort BY Desig</a><br/>
		<a href="displayAllSortBYDesigInDesc">display All Sort BY Desig In Desc Order</a><br/>
		<a href="displayAllSortBYSalaryDescDeptDesc">display All Sort BY Salary In Desc And Dept In Desc</a><br/>
		<a href="displayDotnetEmployeesSortBYSalaryDesc">display Dotnet Employees Sort BY Salary In Desc</a><br/>
		<a href="displayJavaContractorswherenamestartswithBSortedBySalaryDesc">Display JavaContractors where Name starts with b and Basic lower than 25000 Sort By Salary In Desc</a><br/>
		 -->
	</div>
</body>
</html>