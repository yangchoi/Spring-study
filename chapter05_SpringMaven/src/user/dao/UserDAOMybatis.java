package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserDTO;

@Transactional
@Repository // 여기에 userDTO 해주는경우랑 안해주는 경우랑 뭐가 다르지? 
public class UserDAOMybatis implements UserDAO {
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public void write(UserDTO userDTO) {
		int su = sqlSession.insert("userSQL.write", userDTO);
		// commit, close는 tranaction이 해결해준다. 
	}

	@Override
	public List<UserDTO> getUserList() {
		return sqlSession.selectList("userSQL.getUserList");
	}

	@Override
	public UserDTO getUser(String id) {
		return sqlSession.selectOne("userSQL.getUser", id);
	}

	@Override
	public int getUserCount(String id) {
		
		return sqlSession.selectOne("userSQL.getUserCount", id);
	}

	@Override
	public void modify(Map<String, String> map) {
		sqlSession.update("userSQL.modify", map);

	}

	@Override
	public void delete(String id) {
		sqlSession.delete("userSQL.delete", id);

	}

}
