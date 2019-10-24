<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
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
        <h3>create your userName and Password</h3>
        <form:form action="newdetail" method="post" modelAttribute="user" id="myForm">
        <table>
            <tr>
                <td>UserName:</td>
                <td><form:input path="username" id="user"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><form:input path="password" id="pass"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="button" value="Next" onclick="js()"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>