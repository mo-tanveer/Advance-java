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

<form method="post" action="InsertionConfirm.jsp">
	
	<pre>
	 	Enter Employee Name <input type="text" name="text_ename">
	    Enter Employee Salary <input type="text" name="text_salary">
	    
	    <input type="submit" value="insert">
	 	
	</pre>
	</form>
	
	<hr>
	
	<%
		String ename = request.getParameter("text_ename");
	
		double salary = Double.parseDouble(request.getParameter("text_salary"));
		
		Connection cn = (Connection)application.getAttribute("CONN");
		
		PreparedStatement ps = cn.prepareStatement("insert into employee(name,salary) values(?,?)");
		
		ps.setString(1,ename);
		ps.setDouble(2,salary);
		
		int a = ps.executeUpdate();
		
		if(a>0)
		{
			%>
			<jsp:include page="ShowEmployees.jsp"/>
			<% 
		}
	%>
</body>
</html>