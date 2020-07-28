<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form name="imageboardWriteForm" method="post" enctype="multipart/form-data"
action="/miniProject/imageboard/imageboardWrite.do">
 <table border="1" cellspacing="0" cellpadding="5">
  <tr>
   <th width="100">상품코드</th>
   <td><input type="text" name="imageId" value="img_" size="30"></td>
  </tr>
  
  <tr>
   <th>상품명</th>
   <td><input type="text" name="imageName" size="35"></td>
  </tr>
  
  <tr>
   <th>단가</th>
   <td><input type="number" name="imagePrice"></td>
  </tr>
  
  <tr>
   <th>개수</th>
   <td><input type="number" name="imageQty"></td>
  </tr>
  
  <tr>
   <th>내용</th>
   <td>
    <textarea name="imageContent" cols="45" rows="15"></textarea>
   </td>
  </tr>
  
  <tr>
   <td colspan="2">
   	<input type="file" name="image1" size="60">
   </td>
  </tr>
  
  <tr>
   <td colspan=2 align="center">
    <input type="submit" value="이미지 등록">
    <input type="reset" value="다시작성">
   </td>
  </tr>
 </table>
</form>














