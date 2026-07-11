<html>
<body>

<%! 
		String cities [] = {"Lucknow","Kanpur","Noida","Kolkata","Nagpur","Delhi","Ahmedabad","Patna","Surat","Barabanki","Balrampur","Mysore"};

%>

<div align="center">
<form method="post" action="ResponsePage.jsp">
 <table cellpadding="10" cellspacing="0" border="" width="70%" bgcolor="lightyellow">
 <tr>
 <th colspan="4">DROP DOWN DEMO </th>
 </tr>
 
 <tr>
 <td width="25%"></td>
 	<td>Select the capital of India</td>
 	<td>
 	
 		<select name="cmb_capital">
 		 <option value="" selected> -Select Capital-</option>
 		 
 		 
 		<!--   <option value="lucknow">LUCKNOW</option>
 		 <option value="Delhi">DELHI</option>
 		 -->
 		 
 		 <%
 		  for(String value : cities)
 		  {
 			  
 		 %>
 		 
 		 <option value="<%=value%>"><%=value%></option>
 			  
 		<% 
 		  }
 		 %>
 		</select>
 	</td>
 	
 	<tr>
 	
 	<td colspan="4" align="center"><input type="submit" value="Post to Server"></td>
 </tr>
 </table>
</form>
</div>
</body>
</html>
