package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
					// 아래의 value값이 url이 된다 : HandlerMapping 
	@RequestMapping(value="/hello.do", method=RequestMethod.GET)// hello.do라는 요청이 들어온다면 
	// GET 방식으로 REQUEST 하기 
	public ModelAndView hello() {
		// spring은 사용자가 만든 콜백 메서드 
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", "Have a nice day~"); // 이름, 값
		// mav.setViewName("hello"); //view 이름 (hello.jsp 보내주지만 .jsp는 xml에서 spring이 붙여주기로 했기 때문에 .jsp 안붙인다.)
		mav.setViewName("/view/hello");  // servlet에 폴더를 알려주는 property를 없애고 여기에 폴더를 알려준다. 
		return mav;
	}
}
//  <!-- dispatcher 가 곧 mvc-context로 설정이 옮겨간다. -->
//  	<!-- dispatcher가 아래의 mvc-context로 이름을 바꾼다. -->