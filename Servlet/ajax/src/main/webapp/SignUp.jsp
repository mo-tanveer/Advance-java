<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" lang="javascript" src="js/prog3.js"></script>
</head>
<body>

	<div align="center">
		<table cellpadding="10" cellspacing="0" border="0" width="70%" bgcolor="lightyellow">
		
		<tr>
		<td colspan="4" align="center"><b>SIGN UP FORM</b></td>
		</tr>
		
		<tr>
		<td width="25%"></td>
		 <td align="center"> <input type="text" name="txt_uid" placeholder="ENTER USERID" onkeyup="crossCheckID(this.value)"></td>
		  <td></td>
			<td width="25%" id="info"></td>
		</tr>
		
		<tr>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		</tr>
		</table>
	</div>
</body>
</html>