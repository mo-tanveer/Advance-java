<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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
		String uid = request.getParameter("uid");

	Connection cn = (Connection)application.getAttribute("CONN");
	
	PreparedStatement ps = cn.prepareStatement("select * from login where userid=?");
	ps.setString(1,uid);
	
	ResultSet rs = ps.executeQuery();
	
	if(rs.next())
	{
		out.println("<font color=red>Already Exist!</font>");
	}
%>
</body>
</html>