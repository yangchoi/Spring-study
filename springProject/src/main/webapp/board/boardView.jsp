<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<form name="boardViewForm">
<!-- 다른 곳으로 이동할 때 가지고 갈 데이터 -->
<input type="hidden" name="seq" id="seq" value="${seq}"> 
<input type="hidden" name="pg" id="pg" value="${pg}"> 

	<table border="1" cellspacing="0" cellpadding="5" frame="hsides" rules="rows" width="600" style="table-layout:fixed;">
		<tr>
			<td colspan="3"><h3><span id="subjectSpan"></span></h3></td>	
		</tr>
		
		<tr colspan="3">
			<td width="100">글번호 : <span id="seqSpan"></span></td>
			<td width="200">작성자 : <span id="idSpan"></span></td>
			<td width="100">조회수 : <span id="hitSpan"></span></td>	
		</tr>
		
		<tr>
			<td colspan="3" valign=top height="200" 
			style="white-space: pre-wrap; word-break: break-all; overflow: auto;"><span id="contentSpan"></span></td>	
		</tr>
		
	</table>
</form>
	
	<input type="button" value="목록" onclick="location.href='boardList?pg=${pg}'">
	<input type="button" id="" value="답글" onclick="mode(3)">
	
	<span id="boardViewSpan">
		<input type="button" value="글수정" onclick="mode(1)">
		<input type="button" value="글삭제" onclick="mode(2)">
	</span>
	

<script>
function mode(num){
	if(num == 1){
		// 글 수정
		document.boardViewForm.method = 'post'; // 어떤 형태로 이동할 건지 
		document.boardViewForm.action = 'boardModifyForm'; // 어디로 이동할 건지
		document.boardViewForm.submit(); // 데이터 들고 이동 
	}
	if(num == 2){
		// 글 삭제
		if(confirm("삭제? ")){
			document.boardViewForm.method = 'post'; // 어떤 형태로 이동할 건지 
			document.boardViewForm.action = 'boardDelete'; // 어디로 이동할 건지
			// 삭제 전 비밀번호 입력받고 싶으면 form을 따로 만들면 된다. 
			document.boardViewForm.submit(); // 데이터 들고 이동
		}
		
		
	}
	if(num == 3){
		// 답글
		document.boardViewForm.method = 'post'; // 어떤 형태로 이동할 건지 
		document.boardViewForm.action = 'boardReplyForm'; // 어디로 이동할 건지
		document.boardViewForm.submit(); // 데이터 들고 이동
	}
}
</script>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
	$(document).ready(function(){
		$.ajax({
			// 한 사람의 데이터 끌고 오기 
			type : 'post',
			url : '/springProject/board/getBoardView',
			data : 'seq='+$('#seq').val(),
			dataType : 'json',
			success : function(data){
				//alert(JSON.stringify(data));
				
				$('#subjectSpan').text(data.boardDTO.subject);
				$('#seqSpan').text(data.boardDTO.seq);
				$('#idSpan').text(data.boardDTO.id);
				$('#hitSpan').text(data.boardDTO.hit);
				$('#contentSpan').text(data.boardDTO.content);
			},
			error : function(err){
				console.log(err);
			}
			
		});
		
	});
</script>
