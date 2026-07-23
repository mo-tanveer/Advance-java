
<%@page import="java.util.Vector"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	if(session.getAttribute("uid") == null || session.getAttribute("pass") == null)
	{
		response.sendRedirect("ErrorPage.jsp");
	}
%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	

	<div align="center">
	<h4 align="right" ><a href="logout.jsp">logout</a></h4>
	
	<%=session.getId() %>
	
	<form method="post" action="FactorialConfirm.jsp">
		<table cellpadding="10" cellspacing="0" border="0" width="70%" bgcolor="lightyellow">
		
		<tr><th>THE FACTORIAL FORM</th></tr>
		
		<tr><td width="25%"></td><td>Enter Value</td><td><input type="text" name="txt_value"></td><td width="25%"></td></tr>
		
		<tr><td colspan="4" align="center"><input type="submit" value="Factorial"></td></tr>
		</table>
	</form>
	
	<%
int value = Integer.parseInt(request.getParameter("txt_value"));

Vector uv = (Vector)session.getAttribute("uv");

if(uv.contains(value))
{
	out.println("<font color=red>Already Exist!</font>");
	
}
else
{
	out.println("The Factorial of " + value + " is ::" + calculateFactorial(value));
	uv.add(value);
	}

%>
	
	</div>
	
	
	
	<%!
	public long calculateFactorial(int value)
	{
	long result = 1;
	for(int i=1; i<=value; i++)
	{
		result = result*i;
	}
	return result;
	}
%>
</body>
</html>