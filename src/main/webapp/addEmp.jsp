<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
	String message = (String)request.getAttribute("message2");
	if(message!=null) {	
%>
<%= message %>
<% } %>
<form action = "addemp" method = "post">
	ID:<input type = "number" name="ID">
	<br>
	<br>
	Name:<input type = "text" name="name">
	<br>
	<br>
	Address:<input type = "text" name="address">
	<br>
	<br>
	Phone number:<input type = "number" name="phone">
	<br>
	<br>
	Email:<input type = "text" name="email">
	<br>
	<br>
	Password:<input type = "text" name="password">
	<br>
	<br>
	<button> Add employee</button>
	</form>


</body>
</html>