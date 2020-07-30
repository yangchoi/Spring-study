  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<title>글수정</title>
<link rel="stylesheet" href="../css/writeForm.css">
</head>
<body>
<form id="boardModifyForm">
	<input type="hidden" name="seq" id="seq" value="${seq}">
	<input type="hidden" name="pg" id="pg" value="${pg }">

	<table border="1" cellspacing="0" cellpadding="3">
		<tr>
			<td width="100" align="center">제목</td>
			<td><input type="text" name ="subject" id="subject">
				<div id="subjectDiv"></div>
			</td>
		</tr>
		
		<tr>
			<td width="100" align="center">내용</td>
			<td>
			  <textarea rows="15" cols="50" id="content" name="content" style="resize: none;"></textarea>
				<div id="contentDiv"></div>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">		
			<input type="button" value="글수정" id="boardModifyBtn"> 
			<input type="reset" value="다시작성 ">
			
			</td>
				
		</tr>
			
	</table>
</form>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$.ajax({
		// 기존 데이터 끌고 오기
		type : 'post',
		url : '/springProject/board/getBoardView',
		data : 'seq=' + $('#seq').val(),
		dataType : 'json',
		success : function(data){
			$('#subject').val(data.boardDTO.subject);
			$('#content').text(data.boardDTO.content);
		},
		error : function(err){
			console.log(err);
		}
	});
	
});

$('#boardModifyBtn').click(function(){
	$('#subjectDiv').empty();
	$('#contentDiv').empty();
	
	if($('#subject').val() == ''){
		$('#subjectDiv').text('제목을 입력하세요');
		$('#subjectDiv').css('color', 'red');
        $('#subjectDiv').css('font-size', '8pt');
        $('#subjectDiv').css('font-weight', 'bold');
        $('#subjectDiv').focus();
        
	}else if($('#content').val() == ''){
		$('#contentDiv').text('내용을 입력하세요');
		$('#contentDiv').css('color', 'red');
        $('#contentDiv').css('font-size', '8pt');
        $('#contentDiv').css('font-weight', 'bold');
	}else {
		$.ajax({
			type : 'post',
			url : '/springProject/board/boardModify',
			data : $('#boardModifyForm').serialize(),
			success : function(){
				alert('수정 완료');
				location.href='/springProject/board/boardList?pg='+$('#pg').val();
			},
			error : function(err){
				console.log(err);
			}
		});
	}
});


</script>
