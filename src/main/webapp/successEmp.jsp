<%@page import="java.util.List"%>
<%@page import="jsp_employee.EmployeeInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: coral">

<% String value = (String)request.getAttribute("tracking");
	if(value != null) {
%>
	<h2>Changed By <%= value %></h2>
<% } %>
	
<%
	List<EmployeeInfo> list = (List)request.getAttribute("list");
%>

    <table border="10px" >
        <tr style="background-color: darkorange;">
            <th>Id</th>
            <th>Name</th>
            <th>Phone</th>
            <th>Address</th>
            <th>Email</th>
            <th>Password</th>
        </tr>
        <% 
            for(EmployeeInfo employeeInfo : list) {
        %>
        <tr>
            <td><%=employeeInfo.getId() %></td>
            <td><%= employeeInfo.getName() %></td>
            <td><%= employeeInfo.getPhone() %></td>
            <td><%= employeeInfo.getAddress() %></td>
            <td><%= employeeInfo.getEmail() %></td>
            <td><%=employeeInfo.getPassword() %></td>
            <td><a href = "update?id=<%= employeeInfo.getId()%>"><button>UPDATE</button></a></td>
            <td><a href = "delete?id=<%= employeeInfo.getId()%>"><button>DELETE</button></a></td>
        </tr>
        
        <%  
            }
        %>
    </table>
    
    <br>
    <br>
    <center>
        <a href="loginEmp.jsp"><button>log-out</button></a>
        <a href="addEmp.jsp"><button>Add Employee</button></a>
        <a href="deleteall"><button>Delete All</button></a>
    </center>
    </body>
</html>