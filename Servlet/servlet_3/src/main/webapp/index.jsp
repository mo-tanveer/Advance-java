
<%--
<%@page import="java.sql.Connection"%>
<% 
	Connection cn = (Connection)application.getAttribute("CONN");

	if(!cn.isClosed())
	{
		out.println("Database Server Connected");
	}
%>
--%>

<html>
<head></head>

<body>
	<form method="post" action="InsertionConfirm.jsp">
	
	<pre>
	 	Enter Employee Name <input type="text" name="text_ename">
	    Enter Employee Salary <input type="text" name="text_salary">
	    
	    <input type="submit" value="insert">
	 	
	</pre>
	</form>
</body>

</html>