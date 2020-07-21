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
	
	// 해도 되고 안해도 되는데 왜그래?
	//@ResponseBody
	@RequestMapping(value="/user/getUserList", method=RequestMethod.POST)
	public ModelAndView getUserList() {
		// db로 가기 
		List<UserDTO> list = userService.getUserList();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("jsonView");
		
	
		return mav; //json 타입으로 들어가게 된다 
	}
	
	@ResponseBody
	@RequestMapping(value="/user/getUser", method=RequestMethod.POST)
	public JSONObject getUser(String id) {
		JSONObject json = new JSONObject();
		UserDTO userDTO = userService.getUser(id);
		if(userDTO != null) {
			json.put("name", userDTO.getName());
			json.put("id", userDTO.getId());
			json.put("pwd", userDTO.getPwd());
		}
		return json;
	}
	
	
	@RequestMapping(value="/user/modifyForm", method=RequestMethod.GET)
	public String modifyForm() {
		return "/user/modifyForm";
	}
	
	@ResponseBody
	@RequestMapping(value="/user/modify", method=RequestMethod.POST)
	public void modify(@ModelAttribute UserDTO userDTO) {
		userService.modify(userDTO);
	}
}
