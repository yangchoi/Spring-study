package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.SumDTO;

@Controller
public class SumController {
	// input.do 라는 url이 SumController.java 로 찾아가는 것 : HandlerMapping
	/*	
	@RequestMapping(value="/input.do", method=RequestMethod.GET)
	public ModelAndView input() { // 함수이름은 아무거나 해도 된다. 위의 RequestMapping 어노테이션의 주소값을 보고 찾아 오는 것이기 때문
		// 근데 그냥 헷갈리니까 주소값과 같은 이름을 한다. 
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/sum/input"); //sum/input.jsp를 찾아간다. 
		
		// 앞의 HelloController에서는 값을 싣고 jsp 파일로 갔다. 
		// 여기서는 싣고 갈 것이 없다. 그래서 addObject 안한다. 
		
		return mav;
	}
	
	*/
	
	@RequestMapping(value="/input.do", method=RequestMethod.GET)
	// 리턴 타입이 String 이면 단순 문자열이 아니라 뷰의 이름으로 사용된다.
	// 뷰의 이름이 아니라 실제 문자열로 리턴하려면 다음의 어노테이션 >> @ResponseBody 
	public String input() { 		
		return "/sum/input"; // input.jsp(view)를 찾아간다. 
	}
	
	/*
	@RequestMapping(value="/result.do", method=RequestMethod.GET)
	public ModelAndView result() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/sum/result");
		return mav;
		// jsp 파일에 가서 직접 계산
	}
	*/
	
	/*
	// jsp파일에서 계산하지 말고 여기서 데이터를 받아서 계산한다.  // x, y 받음
	@RequestMapping(value="/result.do", method=RequestMethod.GET)
	public ModelAndView result(@RequestParam int x, @RequestParam int y) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("x", x);
		mav.addObject("y", y);
		mav.addObject("sum", x+y);
		mav.setViewName("/sum/result");
		return mav;
	}
	*/
	// 데이터 값이 안들어올 경우 
	
	/*
	@RequestMapping(value="/result.do", method=RequestMethod.GET)
								// 데이터값이 없다면 0으로 설정해준다. 데이터는 int 형으로 받지 않는다. 
	public ModelAndView result(@RequestParam(required = false, defaultValue = "0") String x, 
							   @RequestParam(required = false, defaultValue = "0") String y) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("x", x);
		mav.addObject("y", y);
		mav.setViewName("/sum/result");
		// jsp 파일에서 계산 
		return mav;
	}
	*/
	/*
	// 데이터 map으로 주고받기 
	@RequestMapping(value="/result.do", method=RequestMethod.GET)
	public String result(@RequestParam Map<String, Integer> map, ModelMap modelMap) {
		modelMap.put("x", map.get("x"));
		modelMap.put("y", map.get("y"));
	return "/sum/result";
	*/
	
	// dto로 값 주고받기 
	@RequestMapping(value="/result.do", method=RequestMethod.GET)
	public String result(@ModelAttribute  SumDTO sumDTO, Model model) {
		model.addAttribute("sumDTO", sumDTO); // map역시 통째로 보내도 된다. 
	return "/sum/result";
}
	
}
