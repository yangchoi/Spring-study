package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.SungJukDTO;

// get 방식은 한글 안깨진다. 
// post 는 깨진다. 
@Controller
public class SungJukController {
	// sungJuk : namespace 
	@RequestMapping(value="/sungJuk/input.do", method=RequestMethod.GET)
	// 리턴 타입이 String 이면 단순 문자열이 아니라 뷰의 이름으로 사용된다.
	// 뷰의 이름이 아니라 실제 문자열로 리턴하려면 다음의 어노테이션 >> @ResponseBody 
	public String input() { 		
		return "/sungJuk/input"; // input.jsp(view)를 찾아간다. 
	}
	
	@RequestMapping(value="/sungJuk/result.do", method=RequestMethod.POST)
	public String result(@ModelAttribute SungJukDTO sungJukDTO, ModelMap modelMap) {
		int tot = sungJukDTO.getKor() + sungJukDTO.getEng() + sungJukDTO.getMath();
		double avg = tot/3.0;
		
		sungJukDTO.setTot(tot);
		sungJukDTO.setAvg(avg);
		
		modelMap.addAttribute("sungJukDTO", sungJukDTO);
	return "/sungJuk/result";
	}
}
