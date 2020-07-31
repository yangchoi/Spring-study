package board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.service.BoardService;
// controller에서는 직접 일 잘 안하고 일을 받아서 java에 넘기는 역할만 주로 한다.
// 원래는 모든 일들을 service가 한다. 
// session을 이제 얻어다 써보자..

@Controller
@RequestMapping(value="board")
public class BoardController {
	@Autowired
	private BoardService boardService;

	// 글쓰기 
	@RequestMapping(value="boardWriteForm", method=RequestMethod.GET)
	public String boardWriteForm(Model model) {
		model.addAttribute("display", "/board/boardWriteForm.jsp");
		return "/main/index";
	}
	
	@ResponseBody
	@RequestMapping(value="boardWrite", method=RequestMethod.POST)
	public String boardWrite(@RequestParam Map<String, String> map, Model model) {
		
		boardService.boardWrite(map); // subject, content
		model.addAttribute("display", "/board/boardWrite.jsp");
		
		return "/main/index";
	}
	
	// 글 리스트 
	@RequestMapping(value="boardList", method=RequestMethod.GET)
	public String boardList(@RequestParam(required=false, defaultValue="1") String pg, Model model) {
		// 넘어오는 pg 데이터가 없어서 처음에 400 에러 발생 
		// 데이터가 안들어오는 경우를 명시해 준다 (required=false)
		// 그런 경우는 디폴트 값으로 1페이지로 지정함
		model.addAttribute("pg", pg); // 페이지값 넘겨준다.
		model.addAttribute("display", "/board/boardList.jsp");
		
		return "/main/index";
		
	}
	
	// 5개의 데이터 꺼내옴 
	// 페이징 처리도 여기서 한다. 
	@ResponseBody
	@RequestMapping(value="getBoardList", method=RequestMethod.POST)
	public ModelAndView getBoardList(@RequestParam String pg, HttpSession session, HttpServletResponse response) {
		// 여기서는 required는 있어도 그만 없어도 그만 
		
		String memId = (String) session.getAttribute("memId");
		
		// 쿠키 (조회수 용) - 쿠키는 클라이언트로 보내줘야한다 (클라이언트에 저장)
		if(memId != null) { // 세션값이 존재할 때만 쿠키를 만든다. 
			Cookie cookie = new Cookie("memHit", "ok"); // (쿠키명, 쿠키에 저장할 값)
			cookie.setMaxAge(30*60); // 30분 동안 쿠키 유지 
			cookie.setPath("/"); // 어떤 경로든 쿠키가 들어올 수 있게 
			
			response.addCookie(cookie); // 쿠키를 클라이언트에게 보낸다. 
		}
	
			
		// 한 페이지 당 글 5개
		List<BoardDTO> list = boardService.getBoardList(pg);
		
		
		// 페이징 처리 
		// 페이징 처리를 위해서 필요한 값들은 service에서 가져올 것 
		BoardPaging boardPaging = boardService.boardPaging(pg);
			
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("pg", pg);
		mav.addObject("list", list);
		mav.addObject("boardPaging", boardPaging);
		mav.addObject("memId", memId);
		mav.setViewName("jsonView");
		
		return mav; 

	}
	
	// 검색
	@RequestMapping(value="getBoardSearch", method=RequestMethod.POST)
	public ModelAndView getBoardSearch(@RequestParam Map<String, String> map) {
		List<BoardDTO> list = boardService.getBoardSearch(map);
		
		// 페이징 처리 
		BoardPaging boardPaging = boardService.boardPaging(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", map.get("pg"));
		mav.addObject("list", list);
		mav.addObject("searchOption", map.get("searchOption"));
		mav.addObject("keyword", map.get("keyword"));
		mav.addObject("boardPaging", boardPaging);
		mav.setViewName("jsonView");
		
		return mav;
	}
	
	// 글보기 
	@RequestMapping(value="boardView", method=RequestMethod.GET)
	public String boardView(@RequestParam String seq, @RequestParam String pg, Model model) {
		model.addAttribute("seq", seq);
		model.addAttribute("pg", pg);
		model.addAttribute("display", "/board/boardView.jsp");
		
		return "/main/index";
		//ajax로 처리할 거기 때문에 boardView에서 직접 데이터를 끌고 온다. 
		
	}
	
	// 글보기 
	@RequestMapping(value="getBoardView", method=RequestMethod.POST) // 쿠키값을 가져온다. 쿠키가 없는 경우도 알려준다. 
	public ModelAndView getBoardView(@RequestParam String seq, 
									@CookieValue(value="memHit", required=false) Cookie cookie, 
									HttpServletResponse response, HttpSession session) {
		
		String memId = (String)session.getAttribute("memId");
		
		// 쿠키 - 조회수 증가 
		System.out.println(cookie); // 16진수 레퍼런스 값으로 나옴 
		if(cookie != null) {
			// 쿠키 있을 때 조회수 증가
			boardService.boardHit(seq);
			
			// 조회수 증가시키면 쿠키 삭제 
			cookie.setMaxAge(0); // MAXAGE 0으로 하고
			cookie.setPath("/"); // 모든 경로에서 그렇게 하고
			response.addCookie(cookie); // 클라이언트에게 이 사실을 알린다. 
		}
		
		BoardDTO boardDTO = boardService.getBoardView(seq); // 딱 하나의 데이터만 가지고 옴
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardDTO", boardDTO); // boardDTO 보내기 
		mav.addObject("memId", memId);
		mav.setViewName("jsonView");
		
		return mav;
	}

	
	// 댓글
	@RequestMapping(value="boardReplyForm", method=RequestMethod.POST)
	public String boardReplyForm(@RequestParam String seq, @RequestParam String pg, Model model) {
		
		model.addAttribute("pseq", seq); // 원글 번호
		model.addAttribute("pg", pg); // 원글이 있는 페이지 번호 
		model.addAttribute("display", "/board/boardReplyForm.jsp");
		
		return "/main/index";
		
		
	}
	
	// boardReply에는 데이터가 4개 있다.
	// boardWrite는 2개 있다(제목, 내용)
	@RequestMapping(value="boardReply", method=RequestMethod.POST)
	public String boardReply(@RequestParam Map<String, String> map, Model model) {
		
		boardService.boardReply(map);
		// pseq, pg, subject, content
		model.addAttribute("display", "/board/boardReply.jsp");
		
		return "/main/index";
	}
	
	// 글 수정 
	@RequestMapping(value="boardModifyForm", method=RequestMethod.POST)
	public String boardModifyForm(@RequestParam String seq, @RequestParam String pg, Model model) {
		
		model.addAttribute("seq", seq);
		model.addAttribute("pg", pg);
		model.addAttribute("display", "/board/boardModifyForm.jsp");
		
		return "/main/index";
	}
	
	@ResponseBody
	@RequestMapping(value="boardModify", method=RequestMethod.POST)
	public void boardModify(@RequestParam Map<String, Object> map, Model model) {
		boardService.boardModify(map);

	}
	// 글 삭제는 form 필요없음 
	// 글 삭제 
	@RequestMapping(value="boardDelete", method=RequestMethod.POST)
	public String boardDelete(@RequestParam String seq, Model model) {
		boardService.boardDelete(seq);

		model.addAttribute("display", "/board/boardDelete.jsp");

		return "/main/index";
	}

}
