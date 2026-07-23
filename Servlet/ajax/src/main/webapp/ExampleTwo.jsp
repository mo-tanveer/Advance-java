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

<script lang="JavaScript" type="text/javascript" src="js/prog2.js"></script>
</head>
<body>

		<%
			Connection cn = (Connection)application.getAttribute("CONN");
		
			PreparedStatement ps = cn.prepareStatement("select distinct state_name from state_city");
			ResultSet rs = ps.executeQuery();
		
		%>

		<div align="center">
		<table cellpadding="10" cellspacing="0" border="0" width="70%" bgcolor="lightyellow">
			
			<tr><th>STATE CITY APP</th></tr>
			
			<tr><td align="center">
			
			<select name="cmb_state" style="width:200px" onchange="populateCity(this.value)">
			
			<option value="" selected>-select state name-</option>
			
			<%
			while(rs.next())
			{
				
			%>
				<option value="<%=rs.getString(1)%>"><%=rs.getString(1)%></option>
				
			<%
			     }
			
			%>
			</select>
			
			</td></tr>
			
			<tr><td align="center">
				<select name="cmb_city" style="width:200px;" id="info">
				<option value="" selected>-select city name-</option>
				
				</select>
		
		</table>
		</div>
		
		
		
		
</body>
</html>