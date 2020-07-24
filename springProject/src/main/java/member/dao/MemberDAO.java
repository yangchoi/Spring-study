package member.dao;

import java.util.Map;

import javax.servlet.http.HttpSession;

import member.bean.MemberDTO;

public interface MemberDAO {
	// 로그인 
	public MemberDTO login(Map<String, String> map);
	
}
