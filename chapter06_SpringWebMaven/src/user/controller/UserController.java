package user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONObject;
import user.bean.UserDTO;
import user.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user/writeForm", method=RequestMethod.GET)
	public String writeForm() {
		return "/user/writeForm";
	}
	
	@RequestMapping(value="/user/write", method=RequestMethod.POST)
	@ResponseBody
	public void write(@ModelAttribute UserDTO userDTO) {
		userService.write(userDTO);
	}
	
	@RequestMapping(value="/user/checkId", produces="application/String;charset=UTF-8", method=RequestMethod.POST)
	public @ResponseBody String checkId(@RequestParam String id){
		String result = userService.checkId(id);
		return result;
	}
	
	@RequestMapping(value="/user/deleteForm", method=RequestMethod.GET)
	public String deleteForm() {
		return "/user/deleteForm";
	}
	

	
	@ResponseBody // jsp로 안빠지고 deleteForm으로 감
	@RequestMapping(value="/user/delete", method=RequestMethod.POST)
	public void delete(@ModelAttribute String id) {
		userService.delete(id);
	}
	
	@RequestMapping(value="/user/list", method=RequestMethod.GET)
	public String list() {
		return "/user/list";
	}
	
	/*
	@ResponseBody
	@RequestMapping(value="/user/getUserList", method=RequestMethod.POST)
	public JSONObject getUserList() {
		// db로 가기 
		List<UserDTO> list = userService.getUserList();
		
		
		JSONObject json = new JSONObject();
		if(list != null) {
			JSONArray array = new JSONArray();
			for(int i = 0; i < list.size(); i++) {
				// json 하나씩 꺼내기 
				UserDTO userDTO = list.get(i);
				
				JSONObject temp = new JSONObject();
				temp.put("name", userDTO.getName());
				temp.put("id", userDTO.getId());
				temp.put("pwd", userDTO.getPwd());
				
				array.add(i, temp);
			}
			
			json.put("list", array);
		}
		return json; //json 타입으로 들어가게 된다 
	}
	*/
	
	/*
	// map으로 보내기 
	@ResponseBody
	@RequestMapping(value="/user/getUserList", method=RequestMethod.POST)
	public Map<String, Object> getUserList() {
		// db로 가기 
		List<UserDTO> list = userService.getUserList();
		
		
		JSONArray array = JSONArray.fromObject(list); // 이걸 map에 실어서 보내버린다. 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", array);
	
		return map; //json 타입으로 들어가게 된다 
	}
	*/
	
	@ResponseBody
	@RequestMapping(value="/user/getUserList", method=RequestMethod.POST)
	// Movel 객체와 크게 다르지 않음 
	public ModelAndView getUserList() {
		// db로 가기 
		List<UserDTO> list = userService.getUserList();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list); // 데이터 보냄 
		mav.setViewName("jsonView"); // view 이름 설정 
		
	
		return mav; //json 타입으로 들어가게 된다 
	}

	@RequestMapping(value="/user/modifyForm", method=RequestMethod.GET)
	public String modifyForm() {
		return "/user/modifyForm";
	}
	
	
	// modify 에서 내가 착각한 것 
	// modify를 위해 아이디를 찾아줄 메서드와 수정을 해서 새로운 데이터를 넣어줄 메서드를 동일하게 생각했다. 
	// 하지만 한 메서드에서 두가지 기능을 할 순 없다. 
	// 즉, 아이디를 찾아서 사용자 데이터를 가지고 올 getUser 메서드 하나, 
	// 그 데이터를 수정해서 새로운 데이터를 넣어줄 메서드를 또 하나 로 각자 만들어 줘야 한다. 
	@ResponseBody
	@RequestMapping(value="/user/getUser", method=RequestMethod.POST)
	public JSONObject getUser(@RequestParam String id) {
		JSONObject json = new JSONObject();
		UserDTO userDTO = userService.getUser(id); // 아이디를 들고 간다 
		if(userDTO != null) { // 데이터가 없을 때도 있다... null에 대한 설정을 해줬어야했다..
			json.put("name", userDTO.getName());// 데이터가 있다면 그 데이터를 json에다 싣는다. 
			json.put("id", userDTO.getId());
			json.put("pwd", userDTO.getPwd());
		}
		return json;
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/user/modify", method=RequestMethod.POST)
	public void modify(@ModelAttribute UserDTO userDTO) {
		userService.modify(userDTO);
	}
}
