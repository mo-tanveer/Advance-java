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
	Connection cn = (Connection)application.getAttribute("CONN");

	PreparedStatement ps = cn.prepareStatement("select * from employee");
	
	ResultSet rs = ps.executeQuery();
%>

<table cellpading="5" cellspacing="5" border="0" width="70%" bgcolor="lightyellow">

	<%
	while(rs.next())
	{
		%>
		
		<tr>
			<td><%=rs.getString(1) %></td>
			<td><%=rs.getString(2) %></td>
			<td><%=rs.getString(3) %></td>
			
		</tr>
		
		<% 
	}
	%>
</table>
</body>
</html>