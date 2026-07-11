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
  String[] values = request.getParameterValues("lb_winter");
  out.println("The Recieved cities are :");
  
  for(String value : values)
  {
	  out.println(value + ",");
  }


%>
</body>
</html>