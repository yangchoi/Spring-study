<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
#subjectA:link { color: black; text-decoration: none; }
#subjectA:visited { color: black; text-decoration: none; }
#subjectA:hover { color: blue; text-decoration: underline; }
#subjectA:active { color: black; text-decoration: none; }

#currentPaging {
	color: red;
	text-decoration: underline;
	cursor: pointer;
}
#paging {
	color: black;
	text-decoration: none;
	cursor: pointer;
}
</style>

<input type="hidden" id="pg" value="${pg }">
<table id="boardListTable" border="1" cellspacing="0" cellpadding="5" frame="hsides" rules="rows">
 <tr>
	<th width="100">글번호</th>
	<th width="300">제목</th>
	<th width="150">작성자</th>
	<th width="100">작성일</th>
	<th width="100">조회수</th>				
 </tr> 
</table>

 <div id="boardPagingDiv" style="width: 650px; text-align: center;"></div>
<br>

<form>
<input type="hidden" name="pg" value="1">
<div style="width: 650px; text-align: center;">
	<select name="searchOption" id="searchOption" style="width: 100px;">
 		<option value="subject">제목</option>
 		<option value="id">작성자</option>
	</select>
 	<input type="search" name="keyword" id="keyword" value="${requestScope.keyword }">
	<input type="button" id="boardSearchBtn" value="검색">
</div>
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/boardList.js?var=1"></script>
<script type="text/javascript">
window.onload=function(){
	if("${searchOption }"=="subject" || "${searchOption }"=="id"){
		document.getElementById("searchOption").value = "${searchOption }";
	}
}

function checkLoginMem(seq, pg){
   if('${memId}'=='') {
	   alert("로그인을 먼저 하세요");
	   location.href="../main/index.do";
   
   }else 
	   location.href="boardView.do?seq="+seq+"&pg="+pg;
}

function boardPaging(pg){
	var keyword = document.getElementById("keyword").value;
	if(keyword == ""){
		location.href="boardList?pg="+pg;
	}else{
		$('input[name=pg]').val(pg);
		$('#boardSearchBtn').trigger('click', 'continue');
	}
	
}
</script>









