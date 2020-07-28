<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h3>글수정</h3>
<form name="boardModifyForm" method="post" action="boardModify.do">

<input type="hidden" name="seq" value="${seq }">
<input type="hidden" name="pg" value="${pg }">

<table border="1" cellspacing="0" cellpadding="3">
 <tr>
  <td width="100" align="center">제목</td>
  <td>
   <input type="text" size="50" name="subject" id="subject" value="${boardDTO.subject }">
  </td>
 </tr>

<tr>
 <td width="100" align="center">내용</td>
 <td>
  <textarea rows="15" cols="50" name="content" style="resize: none;">${boardDTO.content }</textarea>
 </td>
</tr>

<tr>
 <td colspan="2" align="center">
  <input type="button" onclick="checkBoardModifyForm()" value="글수정"> 
  <input type="reset" value="다시작성">
 </td>
</tr>
</table>
</form>

<script type="text/javascript">
	function checkBoardModifyForm(){    
		if(document.boardModifyForm.subject.value == ""){
	        alert("제목을 입력하세요.");
	        document.boardModifyForm.subject.focus();
	    } else if(document.boardModifyForm.content.value == "") {
	    	alert("내용을 입력하세요.");
	    	document.boardModifyForm.content.focus();
	    } else  {
	    	document.boardModifyForm.submit();
	    } 
	}
</script>







