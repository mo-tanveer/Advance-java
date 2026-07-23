
<%@page import="java.util.Vector"%>
<%
	Vector usedValues = new Vector();
	session.setAttribute("uv",usedValues);

%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div align="center">
	
	<%=session.getId() %>
	
	<form method="post" action="FactorialConfirm.jsp">
		<table cellpadding="10" cellspacing="0" border="0" width="70%" bgcolor="lightyellow">
		
		<tr><th>THE FACTORIAL FORM</th></tr>
		
		<tr><td width="25%"></td><td>Enter Value</td><td><input type="text" name="txt_value"></td><td width="25%"></td></tr>
		
		<tr><td colspan="4" align="center"><input type="submit" value="Factorial"></td></tr>
		</table>
	</form>
	
	</div>
</body>
</html>