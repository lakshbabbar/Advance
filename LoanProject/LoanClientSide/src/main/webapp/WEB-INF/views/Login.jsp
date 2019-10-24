<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" dir="ltr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" >
<title>Login</title>
<link rel="stylesheet" href="LoanClientSide/src/main/webapp/WEB-INF/views/login.css"> 
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js" charset="utf-8"></script>
<script>
function js(){
	
	if(document.getElementById("user").value == ""){
		alert("user Name is Required");
	} else if (document.getElementById("pass").value == ""){
		alert("Password is Required");
	} else {
		document.getElementById("myForm").submit();
	}
}
</script>
</head>
<body>
   <div align="center">
   <table>
        <form:form action="authentication" method="post" modelAttribute="user" id="myForm">
    		<h1>Login</h1>
    			<tr><td>User Name:</td>
               	<td><form:input path="username" id="user"/></td></tr>
     
     			<tr><td>Password:</td>
              	<td>  <form:password path="password" id="pass"/></td></tr>
               	<tr> <td colspan="2" align="center"> <input type="button" value="Login" onclick="js()"> </td></tr>
        </form:form>
	</table>
	  new user ? Register <a href="newuser">here</a>
	   <h3 style="color: red">${wrong }</h3><br><br>
	</div>
</body>
</html>