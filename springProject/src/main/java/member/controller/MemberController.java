package member.controller;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;
import member.service.MemberService;

@Controller
@RequestMapping(value="member")
public class MemberController {
	@Autowired
	private MemberService memberService;

	// value를 /member/login에서 /member/를 위에 RequestMapping으로 빼서 쓸 수도 있음
	@RequestMapping(value = "login", produces="application/String;charset=UTF-8", method = RequestMethod.POST)
	public @ResponseBody String login(@RequestParam Map<String, String> map, HttpSession session) {
		MemberDTO memberDTO = memberService.login(map);
		System.out.println(map.get("id"));
		String loginFail = null;

		if (memberDTO == null) {
			loginFail = "fail";

		} else {
			// 세션
			session.setAttribute("memName", memberDTO.getName());
			session.setAttribute("memId", map.get("id"));
			session.setAttribute("memEmail", memberDTO.getEmail1() + "@" + memberDTO.getEmail2());

			loginFail = "success";

		}
		return loginFail;
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session, Model model) {
		// 모델...?
		session.invalidate(); // 모두 무효화
		// model.addAttribute("display", "/template/body.jsp");

		return new ModelAndView("redirect:/main/index"); // 바로 이 주소로 가라
		// 얘가 IndexController에 있는 main/index를 value로 갖는 index 메서드로 가서 수행한다.
		// 원래라면 viewResolver를 부르지 않고 바로 redirect(가라)
	}

	// 회원가입
	@RequestMapping(value = "writeForm", method = RequestMethod.GET)
	public String writeForm(Model model) {
		model.addAttribute("display", "/member/writeForm.jsp"); // index 안의 display 에 자리 잡기 때문에 model을 잡아 display를 싣는다
		return "/main/index"; // main화면이 떠야하기 때문에 main/index return
	}
	
	
	// 회원가입
	@RequestMapping(value="write", produces="application/String;charset=UTF-8", method=RequestMethod.POST)
	public String write(@ModelAttribute MemberDTO memberDTO, Model model) {
		memberService.write(memberDTO);
		
		model.addAttribute("display", "/member/write.jsp");
		
		return "/main/index";
	}
	
	// 회원정보 수정
	@RequestMapping(value="modifyForm", method=RequestMethod.GET)
	public String modifyForm(HttpSession session, Model model) {
		// 로그인을 하면 ..님이다 라고 세션에 저장이 되어 있다. 
		// 그 id값을 가지고 온다. (memId)
		// 그럼 매개변수로 세션을 요청한다 (HttpSession)
		String id = (String) session.getAttribute("memId");
		
		// 수정은 입력과 다르게 한 사람 분의 정보를 가지고 와서 뿌려줘야한다. 
		MemberDTO memberDTO = memberService.getMember(id);
		// 아이디 값으로 사용자 한 사람 분의 DTO를 잡아서 뿌려준다. 
		model.addAttribute("memberDTO", memberDTO); // memberDTO 값을 넘겨준다. 
		model.addAttribute("display", "/member/modifyForm.jsp");
		
		return "/main/index";
	}
	
	@ResponseBody
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public void modify(@ModelAttribute MemberDTO memberDTO) {
		memberService.modify(memberDTO);
		// responsebody 해주면 model 필요없고 return 값도 필요 없음. 
	}
		

	// 회원가입 아이디 중복체크
	@ResponseBody
	@RequestMapping(value = "checkId", method = RequestMethod.POST)
	public String checkId(@RequestParam String id) {
		return memberService.checkId(id); // id값도 가져간다.
	}

	// 창띄우는 것부터 먼저하고 거기서 입력받은 값 가져와서 그걸로 list 찾아 넘기기
	// 우편번호 확인
	@RequestMapping(value = "checkPost", method = RequestMethod.GET)
	public String checkPost() {
		return "/member/checkPost";
	}

	
	@RequestMapping(value = "postSearch", method = RequestMethod.POST)
	public ModelAndView postSearch(@RequestParam Map<String, String> map) {
		System.out.println(map.get("sido")); // 값이 온전히 오는지 확인 
		List<ZipcodeDTO> list = memberService.postSearch(map);

		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		return mav;

	}


}
