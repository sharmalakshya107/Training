<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%!
int a = 10;
%>
<%
out.print("this is a script tag<br>");
out.print(a + "<br>");
response.sendRedirect("index2.jsp?a=" + a);
%>
<body>
</body>
</html>
