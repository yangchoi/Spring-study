<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h3>회원정보 수정</h3>
<form id="modifyForm" name="modifyForm">
  <table border="1" cellspacing="0" cellpadding="3">

   <tr>
    <td width="100" align="center"><font color="red"> * </font> 이름 </td>
    <td>
     <input type="text" name="name" id="name" value="${memberDTO.name }">
     <div id="nameDiv"></div>
    </td>
   </tr>
  
   <tr>
    <td align="center"><font color="red"> * </font> 아이디 </td>
    <td>
     <input type="text" size="25" name="id" value="${memberDTO.id }" readonly>
    </td>
   </tr>
   
   <tr> 
    <td align="center"><font color="red"> * </font> 비밀번호 </td>
	<td>
	 <input type="password" size="30" name="pwd" id="pwd">
	 <div id="pwdDiv"></div>
	</td>
   </tr>
   
   <tr> 
    <td align="center"><font color="red"> * </font> 재확인 </td>
	<td>
	 <input type="password" size="30" name="repwd" id="repwd">
	 <div id="repwdDiv"></div>
	</td>
   </tr>

   <tr> 
    <td align="center">성별</td>
	<td>
	 <input type="radio" name="gender" value="0">남 &emsp; 
	 <input type="radio" name="gender" value="1">여 
	</td>
   </tr>
   
   <tr>
    <td align="center">이메일</td>
    <td><input type="text" size="8" name="email1"  value="${memberDTO.email1 }"> @
        <input type="email" size="10" name="email2" id="email2" placeholder="직접입력" list="defaultEmails"> 
        <datalist id="defaultEmails">
         <option value="naver.com">
         <option value="daum.net">
         <option value="gmail.com">
        </datalist></td>
    </tr>
    
    <tr>
     <td align="center">핸드폰</td>
     <td>
      <select name="tel1" style="width: 50px" id="tel1">
      <option value="010">010</option>
      <option value="011">011</option>
      <option value="019">019</option> </select> -
      <input type="text" size="5" name="tel2" value="${memberDTO.tel2 }"> - 
      <input type="text" size="5" name="tel3" value="${memberDTO.tel3 }">
     </td>  
    </tr>
    
    <tr>
     <td align="center">주소</td>
     <td> <input type="text" size="7" name="zipcode" id="zipcode" value="${memberDTO.zipcode }" readonly>
          <input type="button" id="checkPostBtn" value="우편번호검색"><br>
          <input type="text" size="50" name="addr1" id="addr1" placeholder="주소" value="${memberDTO.addr1 }" readonly><br>
          <input type="text" size="50" name="addr2" id="addr2" placeholder="상세주소" value="${memberDTO.addr2 }"><br>    
     </td>
    </tr>
        
    <tr> 
    <td colspan="2" align="center">
	<input type="button" id="modifyBtn" value="회원정보수정"> &emsp; 
	<input type="reset" value="다시입력"> </td>
  </tr>
  </table>
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/member.js"></script>
<script type="text/javascript">
window.onload = function () {	
  	document.modifyForm.gender['${memberDTO.gender }'].checked = true; 	
	document.getElementById("email2").value = "${memberDTO.email2 }";
	document.getElementById("tel1").value = "${memberDTO.tel1 }";
}   
</script>












