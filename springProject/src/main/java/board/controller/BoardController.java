package board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;
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
	public void boardWrite(@RequestParam Map<String, String> map) {
		
		boardService.boardWrite(map);
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
	
	@ResponseBody
	@RequestMapping(value="getBoardList", method=RequestMethod.POST)
	public ModelAndView getBoardList(@RequestParam(required=false, defaultValue="1") String pg) {
		// 여기서는 required는 있어도 그만 없어도 그만 
		
		// 한 페이지 당 글 5개
		List<BoardDTO> list = boardService.getBoardList(pg);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("pg", pg);
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		return mav; 
		
		
	}
	
}
