<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
<table border="1" id="table" align="right">
 <tr>
  <th width="100">이름</th>
  <th width="100">아이디</th>
  <th width="100">비밀번호</th>
 </tr>
 
 <div class="search">
 	<select name="searchOption" id="searchOption">
 		<option value="">선택
 		<option value="name">이름
 		<option value="id">아이디
 	</select>
 	<input type="text" id="searchText" name="searchText">
 	<button id="searchBtn">검색</button>
 </div>
</table>

</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$.ajax({
		type : 'post',
		url: '/chapter06_SpringWebMaven/user/getUserList',
		dataType : 'json',
		// json 형태로 받는다. 
		success : function(data){
			//alert(JSON.stringify(data));
			
			$.each(data.list, function(index, items){
				//alert(items.name + "," + items.id + "," + items.pwd);
				$('<tr/>').append($('<td/>', {
					align : 'center',
					text : items.name
				})).append($('<td/>', {
					align : 'center',
					text : items.id	
				})).append($('<td/>', {
					align : 'center',
					text : items.pwd
				})).appendTo($('#table')); // 총 데이터가 3개이므로 , 부모에게 붙는다 : appendTo
				
			});
			
		}
		
	});
});

// 검색기능 
$('#searchBtn').click(function(){
	$('#searchText').empty();
	
	if($('#searchOption').val() == ''){
		$('#searchText').text('검색 옵션을 먼저 선택해주세요.');
	}
	
	// 검색 버튼을 눌렀을 때..
	if($('searchText').val() == ''){
		$('#searchText').text('검색값을 입력해주세요.');
	}else {
		$('#searchOption').trigger('click');
		// searchOption
});
</script>

</html>