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
  request.setAttribute("student","Tanveer");
%>

<jsp:forward page="SecondPage2.jsp"/>
</body>
</html>