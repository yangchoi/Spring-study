<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
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
#productImg{
	width: 50px;
	height:50px;		
}
</style>

<table border="1" cellspacing="0" cellpadding="5" frame="hsides" rules="rows">
	<tr>
		<th width="100">
			<input type="checkbox" id="all" onclick="checkAll()"> 번호
		</th>
		<th width="200">이미지</th>
		<th width="150">사품명</th>
		<th width="100">단가</th>
		<th width="100">개수</th>
		<th width="100">합계</th>				
 	</tr> 
<c:if test="${list != null }">
	<c:forEach var="imageBoardDTO" items="${list }">
		<tr>
			<td align="center">
				<input type="checkbox" name="check" value="${imageBoardDTO.seq}">${imageBoardDTO.seq}
			</td>
			<td align="center"><img id="productImg" src="../storage/${imageBoardDTO.image1}"></td>
			<td align="center">${imageBoardDTO.imageName}</td>
			<td align="center">
				<fmt:formatNumber pattern="#,###원" value="${imageBoardDTO.imagePrice}" />
				
			</td>
			<td align="center">${imageBoardDTO.imageQty}</td>
			<td align="center">
				<fmt:formatNumber pattern="#,###원" value="${imageBoardDTO.imageQty}" />
			
			</td>
		</tr>
	</c:forEach>
</c:if>
</table>

<div>
<input type="button" value="선택삭제" onclick="choiceDelete()">
<span style="width: 650px; text-align: center;">${imageBoardPaging.pagingHTML}</span>
</div>
<br>

<script type="text/javascript">
// 페이징 처리
function imageBoardPaging(pg){
	location.href="imageBoardList.do?pg="+pg;
}
// 전체선택
function checkAll(){
	//alert(document.getElementById("all").checked)
	//alert(document.getElementById("all").length); // 3개 
	
	let check = document.getElementsByName("check");
	
	if(document.getElementById("all").checked){
		for(i = 0; i < check.length; i++){
			check[i].checked = true;
		}
	}else {
		for(i = 0; i < check.length; i++){
			check[i].checked = false;
		}
	}
}
// 선택삭제
function choiceDelete(){	
	let checkArray = [];
	let check = document.getElementsByName("check");
	
	for(i = 0; i < check.length; i++){
		if(check[i].checked){
			checkArray.push(check[i].value);
		}	
	}
	
	
	let question = confirm("삭제하시겠습니까?");
	if(question == true){
		location='imageBoardChoiceDelete.do?seq='+checkArray;
	}else {
		
	}
	
}
</script>