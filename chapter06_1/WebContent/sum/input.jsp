<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산</title>
</head>
<body>
<form action="result.do" method="get">
<!-- x와 y값은 map으로 묶어서 가져오지만 알아서 매핑된다 -->
	<table border="1">
		<tr>
			<td>X</td>
			<td><input type="text" name="x"></td>
		</tr>
		<tr>
			<td>Y</td>
			<td><input type="text" name="y"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="계산">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>
</body>
</html>