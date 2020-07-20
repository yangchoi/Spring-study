<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form name="writeForm" action="">
    <table border="1" cellspacing="0" cellpadding="3">
      <tr>
        <td width="100">이름</td>
        <td><input type="text" size="15" name="name" id="name">
        	<div id="nameDiv"></div>
        </td>
      </tr>
      <tr>
        <td width="100">아이디</td>
        <td><input type="text" size="15" name="id" id="id">
        	<div id="idDiv"></div>
        </td>
      </tr>
      <tr>
        <td width="100">비밀번호</td>
        <td><input type="password" size="15" name="pwd" id="pwd">
        	<div id="pwdDiv"></div>
        </td>
      </tr> 
      <tr>
        <td colspan="2" align="center">
          <input type="button" id="writeBtn" value="회원가입"> &emsp;
          <input type="reset" value="취소">
        </td>
      </tr>
      
    </table>
  </form> 
   <script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script type="text/javascript" src="../js/user.js"></script>
</body>
</html>