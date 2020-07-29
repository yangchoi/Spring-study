package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	@RequestMapping(value="/main/index", method=RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("display", "/template/body.jsp"); // index에 display 있으므로 위치 알려줌 
		return "/main/index";
	}
}
