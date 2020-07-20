package user.dao;

import user.bean.UserDTO;

public interface UserDAO {

	public UserDTO checkId(String id);

	public void write(UserDTO userDTO);
	
	public void delete(String id);
	
	
}
