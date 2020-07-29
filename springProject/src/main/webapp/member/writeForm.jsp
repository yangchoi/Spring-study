<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="../css/writeForm.css">
<link rel="stylesheet" href="../css/template.css">
</head>



<form id="writeForm" name="writeForm" method="post" action="/springProject/member/write">
		<table>
			<tr width="70">
				<td>이름</td>
				<td><input type="text" id="writeName" name="name" placeholder="이름입력"
					size=10>
					<div id="writeNameCheckDiv"></div>
					</td>
			</tr>

			<tr width="70">
				<td>아이디</td>
				<td><input type="text" id="writeId" name="id" placeholder="아이디입력" size=15>
				<input type="hidden" name="check" id="check" value="">
					<div id="writeIdCheckDiv" ></div>
					</td>
			</tr>
			<tr width="70">
				<td>비밀번호</td>
				<td><input type="password" name="pwd" id = "writePwd" >
					<div id="writePwdCheckDiv" ></div>
				</td>
			</tr>
			<tr width="70">
				<td>비밀번호 재확인</td>
				<td><input type="password" id="writeRepwd" name="repwd">
					<div id="writeRepwdCheckDiv"></div>
				</td>
			</tr>
			<tr width="70">
				<td>성별</td>
				<td><input type="radio" name="gender" value="0"
					checked="checked">남자 <input type="radio" name="gender"
					value="1">여자</td>
			</tr>
			<tr width="70">
				<td>이메일</td>
				<td><input type="text" name="email1"> @ <input
					type="text" name="email2" size="12" list="defaultEmails"
					placeholder="직접입력"> <datalist id="defaultEmails">
						<option value="gmail">
						<option value="naver">
					</datalist></td>
			
			</tr>
			<tr>
				<td>핸드폰</td>
				<td><select name="tel1">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="019">019</option>
				</select> - <input type="text" name="tel2" size=5> - <input
					type="text" name="tel3" size=5></td>
			</tr>
			<tr>
				<td>주소</td>

				<td><input type="text" name="zipcode" id="zipcode" class="zipcode" placeholder="우편번호" size=10> <br>
					<input type="text" name="addr1" id="addr1" size=50 readonly placeholder="주소입력"><br> 
					<input type="text" name="addr2" id="addr2" size=50 placeholder="상세주소입력">
					<div id="checkPostDiv"></div>
					</td>
			</tr>

			<tr>
				<td colspan="2" align="center">
				<input type="button" id="writeBtn" value="회원가입" >&emsp; 
				<input type="reset" id = "button2" value="다시작성"></td>

			</tr>
		</table>

	</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/member.js"></script>