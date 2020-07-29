<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인폼</title>
<style>
* {
	font-family: 'Jeju Gothic', sans-serif;
}
th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}
.button, .button2 {
	background-color: white;
	color: black;
	border: 2px solid #009933;
}
.button:hover {
	background-color: #009933;
	color: white;
}
.button2:hover {
	background-color: #009933;
	color: white;
	
}
</style>
</head>
<body>
	<form id="loginForm">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" id="loginId" name="id" placeholder="아이디입력" size=15>
					<div id="idDiv"></div>
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" id="loginPwd" name="pwd" placeholder="비밀번호 입력 "
					size=15>
					<div id="pwdDiv"></div>
					</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					 <input type="button" id="loginBtn" value="로그인"> &emsp; 
					 <input type="button" value="회원가입" onclick="location.href='/springProject/member/writeForm'"></td>
				<td>
			</tr>
		</table>
		<br><br>
		<div id="loginResultDiv" style="text-align:center"></div>

	</form>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/member.js"></script>
</html>