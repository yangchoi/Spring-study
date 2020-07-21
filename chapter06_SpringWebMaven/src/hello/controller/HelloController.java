package hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class HelloController {

	/*
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public @ResponseBody JSONObject hello() {
		//return "안녕하세요"; // have.jsp를 찾는다. 
		// 단, @ResponseBody 가 있으면 JSP 파일을 찾지 않고 자체적으로 띄운다. 
		
		// json 사용
		JSONObject json = new JSONObject();
		json.put("name", "hong");
		json.put("age", "25");
		
		return json;
		// return 하는 것은 @ResponseBody를 썼기 때문에 가지고 있는 개체 그대로를 브라우저에 넣는다. 
	}
	*/
	
	/*
	 * List 형태의 json
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public @ResponseBody JSONArray hello() {
		JSONArray array = new JSONArray();
		
		JSONObject json = new JSONObject();
		json.put("name", "hong");
		json.put("age", "25");
		array.add(0, json);
		
		json = new JSONObject();
		json.put("name", "yang");
		json.put("age", "25");
		array.add(1, json);
		
		
		
		return array;
		
	}
	*/
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public @ResponseBody JSONObject hello() {
		JSONArray array = new JSONArray();
		
		JSONObject json = new JSONObject();
		json.put("name", "hong");
		json.put("age", "25");
		array.add(0, json);
		
		json = new JSONObject();
		json.put("name", "yang");
		json.put("age", "25");
		array.add(1, json);
		
		JSONObject list = new JSONObject();
		list.put("list", array); // list란 이름의 array 보내기 
		
		return list;
		
	}
	
}
