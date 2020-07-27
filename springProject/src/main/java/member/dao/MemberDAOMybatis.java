package member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import member.bean.MemberDTO;
import member.bean.ZipcodeDTO;

@Repository
@Transactional
public class MemberDAOMybatis implements MemberDAO{
	@Autowired
	private SqlSession sqlSession;
	@Override
	public MemberDTO login(Map<String, String> map) {
		
		return sqlSession.selectOne("memberSQL.login", map);
	}
	
	@Override
	public MemberDTO checkId(String id) {

		return sqlSession.selectOne("memberSQL.checkId", id);
	}

	@Override
	public ZipcodeDTO checkPost() {
		
		return sqlSession.selectOne("memberSQL.checkPost");
	}

	@Override
	public List<ZipcodeDTO> postSearch(Map<String, String> map) {
		
		return sqlSession.selectList("memberSQL.postSearch", map);
	}

	@Override
	public void write(MemberDTO memberDTO) {
		sqlSession.insert("memberSQL.write", memberDTO);
	}


	@Override
	public void modify(MemberDTO memberDTO) {
		
		sqlSession.update("memberSQL.modify", memberDTO);
		
	}

}
