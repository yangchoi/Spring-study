package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import user.bean.UserDTO;


// db도 component써도 되지만 Repository가 좀 더 맞다. 
@Repository("userDAO")
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO{
	
	
	// 오버라이드 안되기 위해서 이름 바꿈
	@Autowired
	public void setDS(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	
	// 입력
	@Override
	public void write(UserDTO userDTO) {
	
		String sql = "insert into usertable values(:name,:id,:pwd)"; // namedParameter
		Map<String, String> map = new HashMap<String, String>();
		// 명시를 해놨기 때문에 순서 상관없음
		map.put("pwd", userDTO.getPwd());
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		
		getNamedParameterJdbcTemplate().update(sql, map);
	}
	
	
	// 출력
	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		
		return getJdbcTemplate().query(sql, 
				new BeanPropertyRowMapper<UserDTO>(UserDTO.class)); // rowmapper : 알아서 행 데이터를 찾아간다. 
	}
	
	// 한 사람 찾기 
	@Override
	public UserDTO getUser(String id) {
		String sql = "select * from usertable where id=?";
								// queryForObject
		try {
		return getJdbcTemplate().queryForObject(
				sql,
				new BeanPropertyRowMapper<UserDTO>(UserDTO.class),
				id);
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	// 사람 찾기 
	@Override
	public int getUserCount(String id) {
		String sql = "select count(*) from usertable where id=?";
	
		return getJdbcTemplate().queryForObject(sql, Integer.class, id); // 위에는 여러개 넘길 수 있는 코드
		// 여기는 하나만 넘길 수 있는 코드 
	}

	// 수정
	@Override
	public void modify(Map<String, String> map) {
		String sql = "update usertable set name=:name, pwd=:pwd where id=:id";
		getNamedParameterJdbcTemplate().update(sql, map);
		
	}

	// 삭제
	@Override
	public void delete(String id) {
		String sql = "delete from usertable where id=:id";
		getJdbcTemplate().update(sql, id);
		
	}
	

	
	

}
