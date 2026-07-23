
<%@page info="information about the" %>
<%@page extends="com.app.MyServlet" %>


<% 
out.println("The Recieved value is ::" + pageContext.getAttribute("Teacher",PageContext.SESSION_SCOPE));

out.println("<hr>");

out.println("The Company value is ::" + pageContext.getAttribute("company",PageContext.APPLICATION_SCOPE));

%>

