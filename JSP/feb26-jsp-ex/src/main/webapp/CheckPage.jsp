<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div align="center">
<form method="post" action="CheckResponse.jsp">

<table cellpadding="10" cellspacing="0" border="0" width="70%" bgcolor="lightyellow">

<tr>
<th colspan="4">What are the states of India?</th>
</tr>

<tr>

<td width="25%"></td>
<td align="right"><input type="checkbox" checked="checked" name="chk_state" value="Beijing"></td>
<td>BEIJING</td>
<td width="25%"></td>
</tr>

<tr>
<td></td>
<td align="right"><input type="checkbox"  name="chk_state" value="Delhi"></td>
<td>DELHI</td>
<td></td>
</tr>

<tr>
<td></td>
<td align="right"><input type="checkbox"  name="chk_state" value="Columbo"></td>
<td>COLUMBO</td>
<td></td>
</tr>

<tr>
<td></td>
<td align="right"><input type="checkbox"  name="chk_state" value="Rajhasthan"></td>
<td>RAJASTHAN</td>
<td></td>
</tr>

<tr>
  <td colspan="4" align="center"><input type="submit" value="Post to Server"></td>
</tr>

</table>

</form>

</div>
</body>
</html>