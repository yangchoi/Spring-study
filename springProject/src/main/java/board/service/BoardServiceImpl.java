package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;
	@Autowired
	private HttpSession session;
	//이제 세션을 여기서 불러서 실어준다. 
	@Autowired
	private BoardPaging boardPaging;
	
	@Override
	public void boardWrite(Map<String, String> map) {
		map.put("id", (String) session.getAttribute("memId"));
		map.put("name", (String) session.getAttribute("memName"));
		map.put("email", (String) session.getAttribute("memEmail"));
		
		boardDAO.boardWrite(map);
		
	}
	
	// 한페이지당 글 5개 
	// 그러기 위해선 startNum과 endNum이 있어야 끊어서 가져온다. 
	@Override
	public List<BoardDTO> getBoardList(String pg) {
		// controller에서가 아닌 일은 service에서 
		int endNum = Integer.parseInt(pg)*5;
		int startNum = endNum - 4;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		return boardDAO.getBoardList(map);
	}
	
	// 페이징 처리 
	@Override
	public BoardPaging boardPaging(String pg) {
		// 총 글 수 얻어오기 
		int totalA = boardDAO.getBoardTotalA();
		boardPaging.setCurrentPage(Integer.parseInt(pg)); //현재 페이지 넣어준다. 
		// currentpage는 int 형이기 때문에 타입 오류 나므로 형변환해줌
		boardPaging.setPageBlock(3); // 3블럭씩 끊어줌
		boardPaging.setPageSize(5); // 5개씩
		boardPaging.setTotalA(totalA);
		boardPaging.makePagingHTML();
		
		return boardPaging;
	}
	
	@Override
	public BoardPaging boardPaging(Map<String, String> map) {
		
		int totalA = boardDAO.getBoardSearchTotalA(map);
		
		boardPaging.setCurrentPage(Integer.parseInt(map.get("pg"))); //현재 페이지 넣어준다. 
		// currentpage는 int 형이기 때문에 타입 오류 나므로 형변환해줌
		boardPaging.setPageBlock(3); // 3블럭씩 끊어줌
		boardPaging.setPageSize(5); // 5개씩
		boardPaging.setTotalA(totalA);
		boardPaging.makePagingHTML();
		
		return boardPaging;
	}
	// 검색
	@Override
	public List<BoardDTO> getBoardSearch(Map<String, String> map) {
		//1페이지당 5개씩
		int endNum = Integer.parseInt(map.get("pg"))*5;
		int startNum = endNum-4;
		
		map.put("startNum", startNum+"");
		map.put("endNum", endNum+"");
		
		return boardDAO.getBoardSearch(map);
	}
	

	@Override
	public BoardDTO getBoardView(String seq) {
		
		return boardDAO.getBoardView(seq);
	}

	// 덧글  
	@Override
	public void boardReply(Map<String, String> map) {
		// 원글 (한 사람 글 가져오기)
		BoardDTO pDTO = boardDAO.getBoardView(map.get("pseq"));
		
		// 원글에 이미 있는 pseq, pg, subject, content
		map.put("id", (String)session.getAttribute("memId"));
		map.put("name", (String)session.getAttribute("memName"));
		map.put("email", (String)session.getAttribute("memEmail"));
		// 덧글이기 때문에 누가 쓴 글에 덧글을 쓰는지 ㅇ라아야한다. 
		
		map.put("ref", pDTO.getRef() +"" ); // 원글 그룹번호
		map.put("lev", pDTO.getLev()+ ""); // 원글 lev + 1
		map.put("step", pDTO.getStep()+ "");// 원글 step + 1
		
		boardDAO.boardReply(map);
		
	}
	
	// 글 수정
	@Override
	public void boardModify(Map<String, Object> map) {
		boardDAO.boardModify(map);
		
		
	}

	@Override
	public void boardDelete(String seq) {
		boardDAO.boardDelete(seq);
		
	}

	// 조회주 증가 
	@Override
	public void boardHit(String seq) {
		boardDAO.boardHit(seq);
		
	}
}
