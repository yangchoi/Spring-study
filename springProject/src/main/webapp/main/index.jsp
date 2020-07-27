<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<link rel="stylesheet" href="../css/template.css">  
</head>
<body>

<table border="1" width="60%" cellspacing="0" cellpadding="5">
		<tr>
			  <td colspan="2" align="center">
				<jsp:include page ="../template/top.jsp" />
			</td>
		</tr>
		<tr>
			  <td width="250" height="400" valign="top">	
			  <jsp:include page ="../template/left.jsp" /></td>
			<td>	<jsp:include page ="${display}" /></td>
		
		</tr>

		<tr>
			  <td colspan="2" align="center">	
			  <jsp:include page ="../template/bottom.jsp" /></td>
		</tr>

</table>

</body>
</html>