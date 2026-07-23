

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%
   Connection cn = (Connection)application.getAttribute("CONN");
   
PreparedStatement ps = cn.prepareStatement("select code from employee");
ResultSet rs = ps.executeQuery();

%>

<div align="center">
		<form method="post" action="SearchConfirm.jsp">
		<table cellpadding="10" cellspacing="10" border="1" width="70%"  bgcolor="lightyellow">
		
			<tr><th colspan="4">Search Employee Code</th></tr>
			<tr> <td width="25%">Select Employee code</td>
			     <td>
			        <select name="cmb_code">
			        <option value="" selected>-select code-</option>
			        
			        <%
			        while(rs.next())
			        {
			        
			        %>
			        
			        <option value="<%=rs.getString(1)%>"><%=rs.getString(1)%></option>
			        <%} %>
			        </select>
			     </td>
			     
			     <td width="25%"></td>
			     </tr>
		
		
		<tr>
		<td colspan="4" align="center"><input type="submit" value="Search"></td>
		</tr>
		</table>
		
		</form>

</div>
