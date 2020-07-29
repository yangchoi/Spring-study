package board.bean;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component // 객체 생성 (다른 곳에서도 써야하니까) >> 어노테이션 선언 : root-context 안에도 알려줌
public class BoardPaging {
	private int currentPage; // 현재 페이지 
	private int pageBlock; // [이전][1][2][3][다음]
	private int pageSize; // 1페이지당 5개씩
	private int totalA; // 총 글수 
	private StringBuffer pagingHTML; 
	
	public void makePagingHTML() {
		pagingHTML = new StringBuffer();
		int totalP = (totalA + pageSize-1) / pageSize;// 총 페이지 수 (한 페이지당 글 5개)
		
		int startPage = (currentPage -1)/pageBlock*pageBlock +1;
		int endPage = startPage +  pageBlock -1;
		if(endPage > totalA) endPage = totalP;
		/*
		// 1 페이지당 5개씩
		int totalA = (totalA + 4)/5;
		// 한페이지당 10개씩
		int totalA = (totalA + 9)/10;
		*/
		
		if (endPage > totalP)
			endPage = totalP; // endpage=9 이고 totalP=8일때 처리하기위한 공식

		if (startPage > pageBlock) {
			pagingHTML.append("[<span id='paging' onclick='boardPaging(" + (startPage - 1) + ")'>이전]</span>");
		}

		for (int i = startPage; i <= endPage; i++) {
			if (i == currentPage) {
				pagingHTML.append("[<span id='currentPaging' onclick='boardPaging(" + i + ")'>" + i + "</span>]");
			} else {
				pagingHTML.append("[<span id='paging' onclick='boardPaging(" + i + ")'>" + i + "</span>]");
			}
		}

		if (endPage < totalP) {
			pagingHTML.append("[<span id='paging' onclick='boardPaging(" + (endPage + 1) + ")'>다음</span>]");
		}
	}
}
