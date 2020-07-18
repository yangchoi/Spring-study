package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Getter
@Setter
public class UserUpdateService implements UserService {
	private UserDTO userDTO;
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		List<UserDTO> list = userDAO.getUserList();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("수정할 아이디 선택  :");
		String id = scan.next();
		/*
 		UserDTO userDTO =userDAO.getUser(id);
 		
 		if(userDTO == null) {
 			System.out.println("찾고자하는 아이디가 없음");
 			return;
 		}
 		*/
		int count = userDAO.getUserCount(id);
		if(count == 0) {
			System.out.println("찾는 아이디 없음");
			return;
		}
		
		UserDTO userDTO = userDAO.getUser(id);
 		System.out.println(userDTO.getName() + "\t" +userDTO.getId() + "\t" + userDTO.getPwd());
 		
 		System.out.print("수정할 이름 입력 : ");
 		String name = scan.next();
 		System.out.print("수정할 비밀번호 입력 : ");
 		String pwd = scan.next();
 		Map<String, String> map = new HashMap<String, String>();
 		map.put("id", id);
 		map.put("name", name);
 		map.put("pwd", pwd);
 		
 		userDAO.modify(map);
 		
 		System.out.println(id + "수정 완료");
	}

}
