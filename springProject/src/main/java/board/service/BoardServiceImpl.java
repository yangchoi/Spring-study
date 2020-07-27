package board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDAO boardDAO;
	@Autowired
	private HttpSession session;
	//이제 세션을 여기서 불러서 실어준다. 
	
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
}
