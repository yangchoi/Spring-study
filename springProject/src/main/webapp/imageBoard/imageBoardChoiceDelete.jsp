<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<script type="text/javascript">
window.onload=function(){
	alert("선택하신 글을 삭제했습니다.");
	// 갈때 페이지 넘버도 같이 가야한다. 
	location.href="../imageBoard/imageBoardList?pg=1";
}
</script>