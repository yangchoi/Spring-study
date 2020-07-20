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
<input type="text" name="deleteId" placholder="삭제할 아이디">
<input type="button" id="deleteBtn" value="검색">
<div id="searchDiv"></div>
</form>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$('#deleteBtn').click(function(){
		$('#searchDiv').empty();
		
		if($('#deleteId').val()==''){
			$('#searchDiv').text('먼저 아이디를 입력하세요');
			$('#searchDiv').css('font-size', '8pt');
			$('#searchDiv').css('color', 'magenta');
			
		}else{
			$.ajax({
				type: 'post',
				url: '/chapter06_SpringWebMaven/user/checkId',
				data: 'id='+$('#id').val(),
				dataType: 'text',
				success: function(data){
					//alert(data);
					if(data == '삭제하시겠습니까?'){
						var result = confirm("아이디를 삭제할까요?");
						if(result){
							location.href="/chapter06_SpringWebMaven/user/delete";
							alert("회원정보를 삭제했습니다.");
						}else {
							return;
						}
						
					}else {
						$('#searchDiv').text('삭제할 아이디가 존재하지 않습니다. ');
						$('#searchDiv').css('font-size', '8pt');
						$('#searchDiv').css('color', 'red');
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