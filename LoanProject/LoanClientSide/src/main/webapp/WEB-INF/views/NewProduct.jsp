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
	
	 if (document.getElementById("res").value == ""){
		alert("Please select Your Residency");
	} else if (document.getElementById("cno").value == ""){
		alert(" Please enter your Contact No");
	} else {
		document.getElementById("myForm").submit();
	}
}
</script>
</head>
<body>
    <div align="center">
        <h2>Enter Product Details</h2>
        <form:form action="/productCheck/" method="post" modelAttribute="product" id="myForm">
        <table border="1">
           
               <form:hidden path="userid" id="id"/>
            <tr>
                <td>Product Name</td>
                <td><form:radiobutton path="producttype" value="gold" id="res"/> Gold<br>
                <form:radiobutton path="producttype" value="platinum" /> Platinum<br> 
                <form:radiobutton path="producttype" value="diamond" /> Diamond<br></td>
            </tr>
             <tr>
                <td>Weight of Product</td>
                <td><form:input path="weight" id="cno"/></td>
            </tr><tr>
                <td colspan="2" align="center"><input type="button" value="Check" onclick="js()"></td>
            </tr>
        </table>
        </form:form>
        <a>${exist }</a>
    </div>
</body>
</html>