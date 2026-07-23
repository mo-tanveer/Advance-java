<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	 out.println("The Session Id in Second response::" + session.getId());
	out.println("<hr>");
	out.println("Hello......." + session.getAttribute("Teacher"));
%>

<hr>
<a href="FirstServlet">Jump to Servlet</a>
</body>
</html>