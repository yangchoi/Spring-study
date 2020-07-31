<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 폼</title>
</head>
<body>
<!-- 파일을 업로드 하려면 enctype="multipart/form-data"가 꼭 있어야하는데 이는 post 방식으로만 처리한다  -->
<form name="imageBoardWriteForm" id="imageBoardWriteForm" method="post" enctype="multipart/form-data" action="/springProject/imageBoard/imageBoardWrite">
	<table border="1" cellspacing="0" cellpadding="3">
		<tr>
			<td width="100" align="center">상품코드</td>
			<td>
				<input type="text" size="30" name="imageId" id="imageId" value="img_">
				<div id="imageIdDiv"></div>
			</td>
		</tr>
		<tr>
			<td width="100" align="center">상품명</td>
			<td>
				<input type="text" size="30" name="imageName" id="imageName" placeholder="상품명 입력">
				<div id="imageNameDiv"></div>
			</td>
		</tr>
		<tr>
			<td width="100" align="center">단가</td>
			<td>
				<input type="number" size="30" name="imagePrice" id="imagePrice" placeholder="단가 입력">
				<div id="imagePriceDiv"></div>
			</td>
		</tr>
		<tr>
			<td width="100" align="center">갯수</td>
			<td>
				<input type="number" size="30" name="imageQty" id="imageQty" placeholder="갯수 입력">
				<div id="imageQtyDiv"></div>
			</td>
		</tr>
		<tr>
			<td width="100" align="center">내용</td>
			<td>
				<textarea name="imageContent" id="imageContent" rows="15" cols="50" style="resize:none;" placeholder="내용입력"></textarea>
				<div id="imageContentDiv"></div>
			</td>
		</tr>
		<tr>
			<td>
				<input type="file" name="img" id="image1" size="50">
				<div id="image1Div"></div>
			</td>
		</tr>
		
		
		<tr>
			<td colspan="2" align="center">		
			<input type="button" value="이미지 등록" id="imageBoardWriteBtn"> 
			<input type="reset" value="다시작성 ">
			
			</td>
				
		</tr>
	
	</table>


</form>
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">

$('#imageBoardWriteBtn').click(function(){
	$('#imageIdDiv').empty();
	$('#imageNameDiv').empty();
	$('#imagePriceDiv').empty();
	$('#imageQtyDiv').empty();
	$('#imageContentDiv').empty();
	$('#image1Div').empty();
	
	if($('#imageId').val() == 'img_' || $('#imageId').val() == ''){
		$('#imageIdDiv').text('상품코드를 입력하세요');
		$('#imageIdDiv').css('color', 'red');
		$('#imageIdDiv').css('font-size', '8pt');
		$('#imageIdDiv').css('font-weight', 'bold');
	}else if($('#imageName').val() == ''){
		$('#imageNameDiv').text('상품이름을 입력하세요');
		$('#imageNameDiv').css('color', 'red');
		$('#imageNameDiv').css('font-size', '8pt');
		$('#imageNameDiv').css('font-weight', 'bold');
	}else if($('#imagePrice').val() == ''){
		$('#imagePriceDiv').text('상품단가을 입력하세요(숫자만 입력)');
		$('#imagePriceDiv').css('color', 'red');
		$('#imagePriceDiv').css('font-size', '8pt');
		$('#imagePriceDiv').css('font-weight', 'bold');
	}else if($('#imageQty').val() == ''){
		$('#imageQtyDiv').text('상품갯수를 입력하세요(숫자만 입력)');
		$('#imageQtyDiv').css('color', 'red');
		$('#imageQtyDiv').css('font-size', '8pt');
		$('#imageQtyDiv').css('font-weight', 'bold');
	}else if($('#imageContent').val() == ''){
		$('#imageContentDiv').text('내용을 입력하세요');
		$('#imageContentDiv').css('color', 'red');
		$('#imageContentDiv').css('font-size', '8pt');
		$('#imageContentDiv').css('font-weight', 'bold');
	} else {
		document.imageBoardWriteForm.submit();
	}

});
</script>

</html>