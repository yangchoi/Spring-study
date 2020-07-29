// 글쓰기 & 덧글

$('#boardWriteBtn').click(function(){
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
		// 현재 화면에 FORM은 하나이므로, FORM의 0번째 것
		document.forms[0].submit();
	
		/*
		$.ajax({
			type : 'post',
			url : '/springProject/board/boardWrite',
			data : {'subject' : $('#subject').val(),
					'content' : $('#content').val()},
			success : function(){
				alert('글쓰기 완료');
				location.href='/springProject/board/boardList';
			},
			error : function(err){
				console.log(err);
			}
		});
		*/
		
		
	}
});





