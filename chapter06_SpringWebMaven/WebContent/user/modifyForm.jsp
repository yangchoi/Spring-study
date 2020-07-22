<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
<style type="text/css">
#modifyFormDiv {
	display: none;
}

#resultDiv {
	font-size: 8px;
	color: red;
}

#nameDiv, #pwdDiv {
	font-size: 8px;
	color: red;
}
</style>
</head>
<body>
	<form id="modifyForm">
		<h4>아이디 수정하기</h4>
		<input type="text" id="modifyId" name="modifyId" placholder="수정할 아이디">
		<input type="button" id="searchBtn" value="검색">
		<div id="resultDiv"></div>

		<div id="modifyFormDiv">
			<table>
				<tr>
					<td>이름 <input type="text" id="name" name="name"
						placeholder="이름">
						<div id="nameDiv"></div>
					</td>
				</tr>
				<tr>
					<td>아이디 <input type="text" id="id" name="id" placeholder="아이디">
					</td>
				</tr>
				<tr>
					<td>비밀번호 <input type="text" id="pwd" name="pwd" placeholder="비밀번호">
						<div id="pwdDiv"></div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
					<input type="button" id="modifyBtn" value="수정">
					<input type="reset" id="resultBtn" value="취소">
					</td>
				</tr>
			</table>
		</div>
	</form>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$('#searchBtn').click(function() {
		$('#resultDiv').empty();

		if ($('#modifyId').val() == '') {
			$('#resultDiv').text('먼저 아이디를 입력하세요');

		} else {
			$.ajax({
				type : 'post',
				url : '/chapter06_SpringWebMaven/user/getUser',
				data : 'id=' + $('#modifyId').val(),
				dataType : 'json',
				success : function(data) {
					//alert(JSON.stringify(data)); // 데이터 왔는지 찍어본다.
					//if ($.isEmptyObject(data)) {
					if (JSON.stringify(data) == JSON.stringify({})) {
						// 현재 아이디가 없음
						$('#resultDiv').text('수정할 아이디가 존재하지 않습니다. ');

					} else {
						// 수정할 아이디 있을 때 
						$('#modifyFormDiv').css('display', 'block');
						$('#name').attr('value', data.name);
						$('#id').attr('value', data.id);

					}

				},
				error : function(err) {
					console.log(err);
				}
			});
		}

	});
	$('#modifyBtn').click(function() {
		$('#nameDiv').empty();
		$('#pwdDiv').empty();

		if ($('#name').val() == '') {
			$('#nameDiv').text('이름 입력');
		} else if ($('#pwd').val() == '') {
			$('#pwdDiv').text('비밀번호 입력');
		} else {

			$.ajax({
				type : 'post',
				url : '/chapter06_SpringWebMaven/user/modify',
				data : $('#modifyForm').serialize(),
				success : function() {
					alert("회원정보를 수정하였습니다");
					location.href = '/chapter06_SpringWebMaven/main/index'
				},
				error : function(err) {
					console.log(err);
				}

			});
		}
	});
	// 취소했을 떄 가지고 왔던 데이터들을 싹다 지우는 reset이 아닌 원래 수정했던 내용 만 지우고 원래 db에 저장되어 있는 데이터를 불러오기 
	// 그러기 위해서는 db를 한 번 더 가야한다. 
$('#resultBtn').click(function(){
	$('#searchBtn').trigger('click'); // resultBtn을 누르면 searchBtn을 누른 것과 같은 효과를 발생시켜라 : trigger
	
	});

</script>
</body>
</html>