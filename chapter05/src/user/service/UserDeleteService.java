package user.service;

import java.util.List;
import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Setter
@Getter
public class UserDeleteService implements UserService {
	
	private UserDTO userDTO;
	private UserDAO userDAO;
	@Override
	public void execute() {
		List<UserDTO> list = userDAO.getUserList();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("삭제할 아이디 선택  :");
		String id = scan.next();
	
		int count = userDAO.getUserCount(id);
		if(count == 0) {
			System.out.println("찾는 아이디 없음");
			return;
		}
		
		userDAO.delete(id);
		
		System.out.println(id + "의 정보삭제");
	}

}
