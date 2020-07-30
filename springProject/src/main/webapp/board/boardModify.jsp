<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
window.onload=function(){
	alert("글 수정 완료");
	location.href="/springProject/board/boardList?pg=${pg}";
	// pg 값을 가져가야한다. 
}
</script>