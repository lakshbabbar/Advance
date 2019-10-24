<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function js(){
	
	if(document.getElementById("name").value == ""){
		alert("Name is Required");
	} else if (document.getElementById("res").value == ""){
		alert("Please select Your Residency");
	} else if (document.getElementById("cno").value == ""){
		alert(" Please enter your Contact No");
	}else if (document.getElementById("add").value == ""){
		alert("Your Address is Required");
	} else {
		document.getElementById("myForm").submit();
	}
}
</script>
</head>
<body>
    <div align="center">
        <h1>Enter Your Details</h1>
        <h2>Your userID is ${id }</h2>
        <form:form action="register" method="post" modelAttribute="detail" id="myForm">
        <table border="1">
           
               <form:hidden path="userid" id="id"/>
          	 <tr >
                <td>Full Name:</td>
                <td><form:input path="fullname" id="name"/></td>
          	</tr>
            <tr>
                <td>Are you Resident Of India.?</td>
                <td><form:radiobutton path="legalresident" value="yes" id="res"/> Yes<br>
                <form:radiobutton path="legalresident" value="no" /> No<br> </td>
            </tr>
             <tr>
                <td>Contact NO</td>
                <td><form:input path="contact_no" id="cno"/></td>
            </tr>
            
              <tr>
                <td>Permanent Address:</td>
                <td><form:textarea path="address" id="add"/></td>
            <tr>
                <td colspan="2" align="center"><input type="button" value="Register" onclick="js()"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>