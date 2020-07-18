package user.service;

import java.util.List;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Setter
public class UserSelectService implements UserService {
	private UserDAO userDAO;

	@Override
	public void execute() {
		//db에서 데이터 꺼내오기 (list 형태로)
		List<UserDTO> list = userDAO.getUserList();
		

		for(UserDTO userDTO : list) {
			System.out.println(userDTO.getName() + "\t" +userDTO.getId() + "\t" + userDTO.getPwd());
		}
	}

}
