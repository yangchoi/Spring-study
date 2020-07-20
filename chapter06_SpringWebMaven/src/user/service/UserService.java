package user.service;

import user.bean.UserDTO;

public interface UserService {

	public String checkId(String id);

	public void write(UserDTO userDTO);
	
	public void delete(String id);
	

}
