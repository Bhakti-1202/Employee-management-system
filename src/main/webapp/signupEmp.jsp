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
	String message = (String)request.getAttribute("message2");
	if(message!=null) {	
%>
<%= message %>
<% } %>
<form action = "signupemp" method = "post">
        <fieldset style="width: 600px; height: 700 px;">
            <legend style="text-align: center;">Sign-up </legend>  	<!--Used to add text on border of fieldset tag-->
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
        <center><button><b>Sign-up</b></button>  </center>
        </form>
    

</body>
</html>