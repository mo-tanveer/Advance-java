<%@page errorPage="ErrorPage.jsp" %>

<% 
	int numerator = Integer.parseInt(request.getParameter("text_num"));
	int denominator =  Integer.parseInt(request.getParameter("text_den"));
	int result = numerator/denominator;
	out.println("Result of the division : "+result);
%>