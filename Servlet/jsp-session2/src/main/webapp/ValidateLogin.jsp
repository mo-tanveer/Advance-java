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

	String uid = request.getParameter("txt_uid");
    String password = request.getParameter("txt_pass");
    
    Connection cn = (Connection)application.getAttribute("CONN");
    
    PreparedStatement ps = cn.prepareStatement("select * from login where userid=? and password=?");
    ps.setString(1,uid);
    ps.setString(2,password);
    
    ResultSet rs = ps.executeQuery();
    if(rs.next())
    {
    	session.setAttribute("uid", uid);
    	session.setAttribute("pass",password);
    	response.sendRedirect("HomePage.jsp");
    }
    else
    {
    	response.sendRedirect("ErrorPage.jsp");
    }
%>
</body>
</html>