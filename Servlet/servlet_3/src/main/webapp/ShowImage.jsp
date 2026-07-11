<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.Blob"%>
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
	int code = Integer.parseInt(request.getParameter("code"));

	Connection cn = (Connection)application.getAttribute("CONN");
	
	PreparedStatement ps = cn.prepareStatement("select image from visual_data where code = ?");
	
	ps.setInt(1,code);
	ResultSet rs_image = ps.executeQuery();
	
	rs_image.next();
	
	Blob _image_in_blob = rs_image.getBlob(1);
	
    //converting into bytes
    byte[] _image_in_bits = _image_in_blob.getBytes(1,(int)_image_in_blob.length());
    
    OutputStream ous = response.getOutputStream();
    
    response.setContentType("image/jpg");
    
    ous.write(_image_in_bits);
    ous.flush();
    ous.close();
    
	
%>
</body>
</html>