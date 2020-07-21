<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
<style type="text/css">
	#modifyFormDiv{
		display:none;
	}
	
	#resultDiv{
		font-size : 8px;
		color : red;
	}
</style>
</head>
<body>
	<form name="modifyForm">
		<h4>아이디 수정하기</h4>
		<input type="text" id="modifyId" name="modifyId" placholder="수정할 아이디"> <input
			type="button" id="modifyBtn" value="검색">
		<div id="resultDiv"></div>

		<div id="modifyFormDiv">
			<table>
				<tr>
					<td>이름 <input type="text" id="name" name="name" placeholder="이름">
					</td>
				</tr>
				<tr>
					<td>아이디 <input type="text" id="id" name="id" placeholder="아이디">
					</td>
				</tr>
				<tr>
					<td>비밀번호 <input type="text" id="pwd" name="pwd" placeholder="비밀번호">
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="button" value="수정"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$('#modifyBtn').click(function() {
		$('#resultDiv').empty();
	
		if ($('#modifyId').val() == '') {
			$('#resultDiv').text('먼저 아이디를 입력하세요');
		
		} else {
			$.ajax({
				type : 'post',
				url : '/chapter06_SpringWebMaven/user/getUser',
				data : 'id='+ $('#modifyId').val(),
				dataType : 'json',
				success : function(data) {
					alert(data.name);
					if (data.name == null) {
						// 현재 아이디가 없음
						$('#resultDiv').text('수정할 아이디가 존재하지 않습니다. ');
	
					
					} else {
						// 수정할 아이디 있을 때 
						$('#modifyFormDiv').css('display','block');
						$('#name').attr('value', data.name);
						$('#id').attr('value', data.id);
						
						
						 $.ajax({
							type : 'post',
							url : '/chapter06_SpringWebMaven/user/modify',
							data : {'id' : $('#id').val()},
							success : function(data) {
								alert($('modifyId').val()); 
								// 값 안넘어옴 
								alert('회원정보를 수정했습니다. ');
							},
							error : function() {

							} 

						});

					}

				},
				error : function(err) {
					console.log(err);
				}
			});
		}

	});
</script>
</html>