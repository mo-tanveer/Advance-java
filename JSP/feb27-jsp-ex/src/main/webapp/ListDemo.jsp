<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%!
	String[] months = {"January","February","March","April","May","June","July","August","October","November","December"};

%>

<form method="post" action="ResponseList.jsp">

<pre>

	<b>Select the months of winter</b>
	
	<select name="lb_winter" multiple="true" size="5">
	<%
		for(String value: months)
		{
	%>
	
	<option value="<%=value%>"><%=value %></option>
	
	<%
	}
	%>
	</select>
	
	<input type="submit" value="post to server">

</pre>
</form>
</body>
</html>