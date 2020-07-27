<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="../css/template.css">

<h3><img src="../image/rick.png" width="50" height="50" 
onclick="location.href='/springProject/main/index'" style="cursor: pointer;"> Spring MVC기반의 미니 프로젝트</h3>

<c:if test="${sessionScope.memId == null }">    
	
</c:if>

<c:if test="${memId != null }">
	<a href="../board/boardWriteForm">글쓰기</a> &emsp;
	<c:if test="${memId == 'admin'}">
	<a href="../imageBoard/imageBoardWriteForm">이미지등록</a> &emsp;
	</c:if>
</c:if>

<a href="../board/boardList">목록</a> &emsp;
<c:if test="${memId == 'admin'}">
<a href="../imageBoard/imageBoardList?pg=1">이미지목록</a> &emsp;
</c:if>