package member.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;
import member.dao.MemberDAO;

// 이 서비스는 Map하고 상관없음
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public MemberDTO login(Map<String, String> map) {

		return memberDAO.login(map);
	}

	// 회원가입 아이디 중복체크
	@Override
	public String checkId(String id) {
		MemberDTO memberDTO = memberDAO.checkId(id); // DTO값을 리턴받아 올 것
		if (memberDTO == null) {
			return "non_exist"; // 사용가능
		} else {
			return "exist"; 
		}
	}

	@Override
	public ZipcodeDTO checkPost() {
		
		return memberDAO.checkPost();
	}

	@Override
	public List<ZipcodeDTO> postSearch(Map<String, String> map) {
		
		return memberDAO.postSearch(map);
	}

	@Override
	public void write(MemberDTO memberDTO) {
		memberDAO.write(memberDTO);
		
	}

	@Override
	public MemberDTO getMember(String id) {
		
		return memberDAO.checkId(id);
	}

	// 회원정보 수정
	@Override
	public void modify(MemberDTO memberDTO) {
		memberDAO.modify(memberDTO);		
	}

}
