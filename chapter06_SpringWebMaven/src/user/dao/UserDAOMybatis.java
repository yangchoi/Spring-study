package user.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserDTO;

@Repository
@Transactional
public class UserDAOMybatis implements UserDAO{
	@Autowired
	private SqlSession sqlSession;
	
	// 아이디 찾기 
	@Override
	public UserDTO checkId(String id) {
		
		return sqlSession.selectOne("userSQL.checkId", id);
	}

	// 회원가입
	@Override
	public void write(UserDTO userDTO) {
		
		sqlSession.insert("userSQL.write", userDTO);
		
	}
	
	// 아이디 삭제
	@Override
	public void delete(String id) {
		sqlSession.delete("userSQL.delete", id);
		
	}

}
