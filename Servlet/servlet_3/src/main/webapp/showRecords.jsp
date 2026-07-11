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
	Connection cn=(Connection)application.getAttribute("CONN");

PreparedStatement ps = cn.prepareStatement("select * from visual_data");

ResultSet rs = ps.executeQuery();

%>

<div align="center">
<table cellpading="10" cellspacing="0" border="1" width="70%" bgcolor="lightyellow">

 <%
 	while(rs.next())
 	{
 %>
 	<tr>
 		<td><%=rs.getString(1)%></td>
 		<td><%=rs.getString(2)%></td>
 		<td><img src="ShowImage.jsp?code=<%=rs.getString(1)%>" height="120" width="120"/></td>
 		
 	</tr>
 	<% 	
 	}
%>

</table>
</div>
</body>
</html>