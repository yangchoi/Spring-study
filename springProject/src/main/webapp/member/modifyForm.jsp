<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="../css/writeForm.css">
<link rel="stylesheet" href="../css/template.css">


<!-- ajax로 넘기는 값 잡으면 form을 id로 잡고, action, method는 다 ajax에서 정하기 -->
<form id="modifyForm">
<h3>회원정보 수정</h3>
		<table>
			<tr width="70">
				<td>이름</td>
				<td><input type="text" value="${memberDTO.name}" id="modifyName" name="name" placeholder="이름입력"
					size=10>
					<div id="nameCheckDiv"></div>
					</td>
			</tr>

			<tr width="70">
				<td>아이디</td>
				<td><input type="text" value="${memberDTO.id}" id="id" name="id" placeholder="아이디입력" size=15 readonly>
					<div id="idCheckDiv" ></div>
					</td>
			</tr>
			<tr width="70">
				<td>비밀번호</td>
				<td>
					<input type="password" name="pwd" id = "modifyPwd" >
					<div id="pwdCheckDiv" ></div>
				</td>
			</tr>
			<tr width="70">
				<td>비밀번호 재확인</td>
				<td>
				<input type="password" id="modifyRepwd" name="repwd">
				<div id="repwdCheckDiv"></div>
				</td>
			</tr>
			<tr width="70">
				<td>성별</td>
				<td>
				<input type="radio" name="gender" value="0" checked="checked">남자 <input type="radio" name="gender"
					value="1">여자</td>
			</tr>
			<tr width="70">
				<td>이메일</td>
				<td><input type="text" value="${memberDTO.email1}" name="email1"> @ 
					<input type="text" name="email2" size="12" list="defaultEmails"
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
				<input type="button" id="modifyBtn" value="정보수정" >&emsp; 
				<input type="reset" id = "button2" value="다시작성"></td>

			</tr>
		</table>

	</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/member.js"></script>
<script type="text/javascript">
window.onload = function(){
	document.getElementById("modifyForm").gender[$(memberDTO.gender)].checked = true;
	document.getElementById("email2").value = "${memberDTO.email2 }";
	document.getElementById("tel1").value = "${memberDTO.tel1 }";
}
</script>
