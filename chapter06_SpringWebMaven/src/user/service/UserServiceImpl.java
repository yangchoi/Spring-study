package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
}
