<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<h2>This is JSP File</h2>
<%!
	// Declaration Tag
	int a = 5;
	String name = "Akshat";
%>
<h3>
<%
out.print("This is Scriplet Tag | ");
out.print(name + " | ");
out.print(a);
response.sendRedirect("Test2.jsp");
%>
</h3>
<h1>
<%= "I am Akshat Sharma" %>
</h1>
</body>
</html>