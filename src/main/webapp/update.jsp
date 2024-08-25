<%@page import="jsp_employee.EmployeeInfo"%>
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
	EmployeeInfo info = (EmployeeInfo)request.getAttribute("obj");
%>

<form action="editinfo" method = "post">

	ID: <input type = "hidden" name = "id" value = <%= info.getId() %> readonly="readonly">
	<br>
	<br>
	Name:<input type = "text" name="name" value = <%= info.getName()%>>
	<br>
	<br>
	Address:<input type = "text" name="address" value = <%= info.getAddress()%>>
	<br>
	<br>
	Phone number:<input type = "number" name="phone"  value = <%= info.getPhone()%>>
	<br>
	<br>
	Email:<input type = "text" name="email"  value = <%= info.getEmail()%>>
	<br>
	<br>
	Password:<input type = "text" name="password"  value = <%= info.getPassword()%>>
	<br>
	<br>
	<button>UPDATE</button>
</form>
	

</body>
</html>