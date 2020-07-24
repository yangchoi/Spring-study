package member.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import member.bean.MemberDTO;
import member.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberController {
	@Autowired
	private MemberService memberService;

	
	// value를 /member/login에서 /member/를 위에 RequestMapping으로 빼서 쓸 수도 있음
	@RequestMapping(value="login", method=RequestMethod.POST)
	public @ResponseBody String login(@RequestParam Map<String, String> map, HttpSession session) {
		MemberDTO memberDTO = memberService.login(map);
		System.out.println(map.get("id"));
		String loginFail = null;
		
		if(memberDTO == null) {
			loginFail = "fail";
			
		}else {
			//세션
			session.setAttribute("memName", memberDTO.getName());
			session.setAttribute("memId", map.get("id"));
			session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
			
			loginFail = "success";
			
		}
		return loginFail;
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session, Model model) {
		// 모델...?
		session.invalidate(); // 모두 무효화
		//model.addAttribute("display", "/template/body.jsp");
		
		return new ModelAndView("redirect:/main/index"); // 바로 이 주소로 가라 
		// 얘가 IndexController에 있는 main/index를 value로 갖는 index 메서드로 가서 수행한다. 
		// 원래라면 viewResolver를 부르지 않고 바로 redirect(가라)
	}
	
	// 회원가입
	@RequestMapping(value="writeForm", method=RequestMethod.GET)
	public String writeForm(Model model) {
		model.addAttribute("display", "/member/writeForm.jsp"); // index 안의 display 에 자리 잡기 때문에 model을 잡아 display를 싣는다
		return "/main/index"; //main화면이 떠야하기 때문에 main/index return 
	}
	
	// 회원가입 아이디 중복체크
	@ResponseBody
	@RequestMapping(value="checkId", method=RequestMethod.POST)
	public String checkId(@RequestParam String id) {
		return "";
	}
}
