package user.dao;

import java.util.List;
import java.util.Map;

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
   
	// 출력
	@Override
	public List<UserDTO> getUserList() {
		
		return sqlSession.selectList("userSQL.getUserList");
	}

	// 수정 값 가져오기 
	@Override
	public UserDTO getUser(String id) {
		return sqlSession.selectOne("userSQL.getUser", id); // id를 가지고 가야한다. 
	}

	// 수정 
	
	@Override
	public void modify(UserDTO userDTO) {
		sqlSession.update("userSQL.modify", userDTO);
		
	}
	
	

}
