<%@page import="java.util.Vector"%>
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
	Vector uv = (Vector)session.getAttribute("uv");

	for(int i=0;i<uv.size();i++)
	{
		
	%>
		
		<h4 align="center"><%=uv.get(i)%></h4>
	
<%
	}
%>

</body>
</html>