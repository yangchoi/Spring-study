<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<form name="boardReplyForm" method="post" action="/springProject/board/boardReply">
<input type="hidden" name="pseq" value="${pseq}">
<input type="hidden" name="pg" value="${pg}">
<!-- boardView에서 부터 받은 pseq, pg를 BoardReplyFormService에서 받아서 request로 boardReplyForm으로 보내는데 그걸 form에서도 계속 가지고 있는다 -->
	<table border="1" cellspacing="0" cellpadding="3">
		<tr>
			 <td width="100" align="center"> 제목 </td>
			 <td><input type="text" size="50" name="subject" id="subject" placeholder="제목 입력">
			 <div id="subjectDiv"></div>
			 </td>
		</tr>
		
		<tr>
			<td width="100" align="center"> 내용 </td>
			<td><textarea name="content" id="content" rows="15" cols="50"  style="resize:none;" placeholder="내용을 입력"></textarea>
			<div id="contentDiv"></div>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">		
			<input type="button" value="답글쓰기" id="boardWriteBtn"> 
			<input type="reset" value="다시작성 ">
			
			</td>
				
		</tr>
			
	</table>
</form>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/board.js?var=1"></script>
