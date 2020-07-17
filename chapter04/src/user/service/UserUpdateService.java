package user.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Setter
public class UserUpdateService implements UserService {
	private UserDAO userDAO;

	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.println();
		System.out.print("수정할 아이디 입력 : ");
		String id = scanner.next();
		
		/*
		UserDTO userDTO = userDAO.getUser(id);
		if(userDTO == null) {
			System.out.println("찾고자 하는 아이디가 없습니다");
			return;
		}
		*/
		
		int count = userDAO.getUserCount(id);
		if(count == 0) {
			System.out.println("찾고자 하는 아이디가 없습니다");
			return;
		}
		
		UserDTO userDTO = userDAO.getUser(id);
		System.out.println(userDTO.getName()+"\t"+userDTO.getId()+"\t"+userDTO.getPwd());
		
		System.out.println();
		System.out.print("수정할 이름 입력 : ");
		String name = scanner.next();
		System.out.print("수정할 비밀번호 입력 : ");
		String pwd = scanner.next();
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("name", name);
		map.put("id", id);
		map.put("pwd", pwd);
		
		userDAO.modify(map);
		
		System.out.println(id + "님의 정보를 수정 완료");
	}
}












