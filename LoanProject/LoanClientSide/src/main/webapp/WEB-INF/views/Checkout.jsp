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
	
	if (document.getElementById("amt").value == 0){
		alert("amount cannot be Zero");
	} else {
		document.getElementById("difform").submit();
	}
}
</script>
</head>
<body>
    <div align="center">
        <h3>Enter property Details</h3>
          <table border="1" >
        <form:form action="/checkout" method="post" modelAttribute="loan" id="difform">
      
           <form:hidden path="userid" />
            <form:hidden path="propertyid" />
             <form:hidden path="area_code" />
            <form:hidden path="property_sq" />
          
        	<tr >
                <td>Amount Available to loan:</td>
                <td>${amount }</td>
          	</tr>
          	 <tr >
                <td>enter Amount You Require:</td>
                <td><form:input path="amount" id="amt"/></td>
          	</tr>
          	<tr>
                <td colspan="2" align="center"><input type="button" value="Check" onclick="js()"></td>
            </tr>

        </form:form>
                </table>
                <a>${confirm }</a>
                 <a href="/homered/${loan.userid }"><input type="button" value="Back To Home" ></a>
    </div>
</body>
</html>