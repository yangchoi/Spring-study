package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
import user.bean.UserDTO;

@Transactional
public class UserDAOMybatis implements UserDAO {
	@Setter
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
