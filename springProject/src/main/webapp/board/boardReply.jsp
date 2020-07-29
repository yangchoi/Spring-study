<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
window.onload=function(){
	alert("작성하신 답글을 저장 하였습니다");
	// 원글과 답글은 같이 움직이기 때문에 
	// 페이지를 넘길 때 가지고 있는 pg를 그대로 넘겨줘야한다. 
	location.href="../board/boardList?pg=${pg}";
}
</script>