<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index2</title>
</head>
<body>
<%
String aParam = request.getParameter("a");
int a = 0;
if (aParam != null) {
    try {
        a = Integer.parseInt(aParam);
    } catch (NumberFormatException e) {
        	
        a = 0;
    }
}
out.print("The value of a is: " + a);
%>
</body>
</html>
