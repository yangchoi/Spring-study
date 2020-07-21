package user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONObject;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public String checkId(String id) {
		// db 확인 
		UserDTO userDTO = userDAO.checkId(id);
		
		if(userDTO == null) 
			return "사용가능";
		else 
			return "사용불가능";
		
	}

	@Override
	public void write(UserDTO userDTO) {
		userDAO.write(userDTO);
		
	}

	@Override
	public void delete(String id) {
		userDAO.delete(id);
		
	}

	@Override
	public List<UserDTO> getUserList() {
		return userDAO.getUserList();
	}

	@Override
	public void modify(UserDTO userDTO) {
		userDAO.modify(userDTO);
		
	}

	@Override
	public UserDTO getUser(String id) {
		
		return userDAO.checkId(id);
	}





}
