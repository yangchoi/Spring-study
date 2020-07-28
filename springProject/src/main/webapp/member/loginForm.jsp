<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form id="loginForm">
   <table cellspacing="0" cellpadding="3">
   
    <tr>
     <td width="100" align="center">아이디</td>
     <td>
      <input type="text" name="id" class="id" placeholder="아이디입력">
      <div class="idDiv"></div>
     </td>
    </tr>
    
    <tr>
     <td width="100" align="center">비밀번호</td>
     <td>
      <input type="password" name="pwd" class="pwd" placeholder="비밀번호입력">
      <div class="pwdDiv"></div>
     </td>
    </tr>   
    
    <tr> 
     <td colspan="2" align="center">
	 <input type="button" id="loginBtn" value="로그인"> &emsp; 
	 <input type="button" value="회원가입" 
	 onclick="location.href='/springProject/member/writeForm'"></td>
    </tr>

   </table>
   <br><br>
   <div id="loginResultDiv" style="text-align: center"></div>
</form>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/member.js"></script>













