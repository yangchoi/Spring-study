package user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserSelectService implements UserService {
	@Autowired
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
