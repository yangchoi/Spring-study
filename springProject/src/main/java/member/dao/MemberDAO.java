package member.dao;

import java.util.List;
import java.util.Map;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

public interface MemberDAO {
	// 로그인 
	public MemberDTO login(Map<String, String> map);
	
	// 회원가입시 아이디 중복체크
	public MemberDTO checkId(String id);
	
	public ZipcodeDTO checkPost();

	public List<ZipcodeDTO> postSearch(Map<String, String> map);

	public void write(MemberDTO memberDTO);

	public void modify(MemberDTO memberDTO);
}
