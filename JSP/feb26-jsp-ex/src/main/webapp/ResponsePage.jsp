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
 String receivedValue = request.getParameter("rdb_capital");

out.println("The Received Value is :: " + receivedValue);

%>
</body>
</html>