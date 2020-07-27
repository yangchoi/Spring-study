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
</style>
<!-- controller로부터 넘어온 pg값, modelAttribute로 넘기고 있는 pg값은 여기 pg값이다.  -->
<input type="hidden" id="pg" value="${pg}">
<table id="boardListTable" border="1" cellspacing="0" cellpadding="5" frame="hsides" rules="rows">
 <tr>
	<th width="100">글번호</th>
	<th width="200">제목</th>
	<th width="150">작성자</th>
	<th width="100">작성일</th>
	<th width="100">조회수</th>				
 </tr> 
</table>

<form>
<!-- 따로 이 페이지에서 쓰는 form 안에서의 pg (위와는 다른 pg값 )  -->
<input type="hidden" name="pg" value="1">
<div style="width:650px; text-align: center;">
	<select name="searchOption" id="searchOption" style="width: 100px;">
 		<option value="subject">제목</option>
 		<option value="id">작성자</option>
	</select>
 	<input type="search" id="keyword" name="keyword" value="${requestScope.keyword }">
	<input type="submit" value="검색">
</div>
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/boardList.js"></script>