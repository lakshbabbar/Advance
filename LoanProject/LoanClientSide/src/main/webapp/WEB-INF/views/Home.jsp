<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h2> Welcome ${user.username } (Prime Member)</h2>
 apply loan on New Property<a href="/applyloanNew/${userid }"> here</a><br><br>
  apply loan on Existing Property <a href="/loanlist/${userid }"> here</a><br><br>
  apply loan on New product<a href="/applyloanNewProduct/${userid }"> here</a><br><br>
  apply loan on Existing Product <a href="/loanlistProduct/${userid }"> here</a>
 </center>
</body>
</html>