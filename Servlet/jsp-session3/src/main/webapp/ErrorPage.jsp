<%@page isErrorPage="true"%>


<% 
	out.println("Reason of the error : "+exception.getMessage());
	
%>