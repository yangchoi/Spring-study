<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
.productImage{
	width: 50px;
	height: 50px;
}

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

<form name="imageboardListForm" method="" action="/miniProject/imageboard/imageboardDelete.do">
<table border="1" cellspacing="0" cellpadding="5" frame="hsides" rules="rows">
 <tr>
  <th width="100">
   <input type="checkbox" id="all" onclick="checkAll()">번호
  </th>
  <th width="100">이미지</th>
  <th width="300">상품명</th>
  <th width="100">단가</th>
  <th width="100">개수</th>
  <th width="100">합계</th>
 </tr>
 
 <c:if test="${list != null }">
  <c:forEach var="imageboardDTO" items="${list }">
   <tr>
    <td align="center">
     <input type="checkbox" name="check" value="${imageboardDTO.seq }">${imageboardDTO.seq }
    </td>
    <td align="center">
     <a href="/miniProject/imageboard/imageboardView.do?seq=${imageboardDTO.seq }&pg=${pg}">
      <img class="productImage" src="../storage/${imageboardDTO.image1 }">
     </a>
     </td>
    <td align="center">${imageboardDTO.imageName }</td>
    <td align="center">
     <fmt:formatNumber pattern="#,###원" value="${imageboardDTO.imagePrice }" />
    </td>
    <td align="center">${imageboardDTO.imageQty }</td>
    <td align="center">
     <fmt:formatNumber pattern="#,###원" value="${imageboardDTO.imagePrice * imageboardDTO.imageQty }" />
    </td>
   </tr>
  </c:forEach>
 </c:if>
</table>
</form>

<div style="width: 900px;">
	<c:if test="${sessionScope.memId == 'admin'}">
		<div style="float: left; width: 100px;">
		<input type="button" onclick="choiceDelete()" value="선택삭제">
		</div>
	</c:if>
	<div style="width: 700px; text-align: center; display: inline-block;">
	<!-- <div style="float: left; border: 1px red solid; width: 700px; text-align: center;"> -->
		${imageboardPaging.pagingHTML }
	</div>
</div>

<script>
function imageboardPaging(pg){
    location.href="imageboardList.do?pg="+pg;
}

function checkAll(){
	//alert(document.getElementById("all").checked)
	//alert(document.getElementsByName("check").length) - 3개
	
	let check = document.getElementsByName("check");
	if(document.getElementById("all").checked){
		for(i=0; i<check.length; i++){
			check[i].checked = true;
		}
	}else{
		for(i=0; i<check.length; i++){
			check[i].checked = false;
		}
	}
}

function choiceDelete(){
	let check = document.getElementsByName("check");
	let count = 0;
	for(i=0; i<check.length; i++){
		if(check[i].checked) count++;
	}
	
	if(count==0)
		alert("삭제할 제품을 선택하세요");
	else
		if(confirm("삭제하시겠습니까?"))
			document.imageboardListForm.submit();
	
}
</script>












