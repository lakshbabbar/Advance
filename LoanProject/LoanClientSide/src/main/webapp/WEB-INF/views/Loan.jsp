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
	
	if(document.getElementById("propid").value == 0){
		alert("property id cannot be Zero");
	} else if (document.getElementById("prop").value == 0){
		alert("please enter property area_sq");
	} else if (document.getElementById("area").value <= 0 || document.getElementById("area").value >200){
		alert("area code should be between 1  and 200");
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
        <form:form action="/loancheck" method="post" modelAttribute="loan" id="difform">
      
           <form:hidden path="userid" />
            <tr >
                <td>property Id</td>
                <td><form:input path="propertyid" id="propid"/></td>
          	</tr>
           <tr >
                <td>property in sqFeet</td>
                <td><form:input path="property_sq" id="prop"/></td>
          	</tr>
            <tr >
                <td>Area Code</td>
                <td><form:input path="area_code" id="area"/></td>
          	</tr>
          	<tr>
                <td colspan="2" align="center"><input type="button" value="Check" onclick="js()"></td>
            </tr>

        </form:form>
                </table>
                <a>${exist }</a><br><br>
                <a>${amount }</a>
    </div>
</body>
</html>