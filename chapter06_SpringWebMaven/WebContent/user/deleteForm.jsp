<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     import="user.dao.UserDAO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="deleteForm">
	<h4>아이디 삭제하기</h4>
	<input type="text" id="deleteId" name="deleteId" placholder="삭제할 아이디">
	<input type="button" id="deleteBtn" value="검색">
	<div id="resultDiv"></div>
</form>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$('#deleteBtn').click(function(){
		$('#resultDiv').empty();
		
		if($('#deleteId').val()==' '){
			$('#resultDiv').text('먼저 아이디를 입력하세요');
			$('#resultDiv').css('font-size', '8pt');
			$('#resultDiv').css('color', 'magenta');
			
		}else{
			$.ajax({
				type: 'post',
				url: '/chapter06_SpringWebMaven/user/checkId',
				data: 'id='+$('#id').val(),
				dataType: 'text',
				success: function(data){
					//alert(data);
					if(data == '사용가능'){
						// 현재 아이디가 없음
						$('#resultDiv').text('삭제할 아이디가 존재하지 않습니다. ');
						$('#resultDiv').css('font-size', '8pt');
						$('#resultDiv').css('color', 'red');
						
					}else {
						if(comfirm('삭제할까요?')){
							$.ajax({
								type : 'post',
								url : '/chapter06_SpringWebMaven/user/delete',
								data : {'id' : $('#id').val()},
								success : function(){
									alert('회원정보를 삭제했습니다');
								},
								error : function(){
									
								}
								
							});
						}
					}
			
				},
				error: function(err){
					console.log(err);
				}
			});
		}

});
</script>
</html>