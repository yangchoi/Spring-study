package member.service;

import java.util.Map;

import member.bean.MemberDTO;

public interface MemberService {

	public MemberDTO login(Map<String, String> map);
	
}
