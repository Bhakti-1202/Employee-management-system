<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: coral">
<% 
	String message = (String)request.getAttribute("message");
	if(message!=null) {	
%>
<%= message %>
<% } %>
<form action = "loginemp" method = "post">
	<form>
		<fieldset style="height:200px">
			<legend style="text-align: center;"><b>Login</b></legend>
			<br>
			<input type="text" required placeholder="Username" autofocus name="email" style="text-align: center;align-content: center;">
			<br><br>
			<input type="password" name="password" required autofocus >

			<br><br><br>
			<center><button><b>Login</b></button>  </center>
		</fieldset>
	</form>
</body>
</html>