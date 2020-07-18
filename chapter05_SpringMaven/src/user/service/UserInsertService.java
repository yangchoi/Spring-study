package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import user.bean.UserDTO;
import user.dao.UserDAO;

// 같은 어노테이션이 걸려있는 dto에 같은 타입을 찾아간다(mapping) : autowired
@Service // component보다 좀 더 세분화된 service를 사용한다. 
public class UserInsertService implements UserService {
	@Autowired 
	private UserDTO userDTO;
	@Autowired 
	private UserDAO userDAO;


	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("아이디 입력 : ");
		String id = scan.next();
		System.out.print("비밀번호 입력 : ");
		String pwd = scan.next();
		
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);
		
		userDAO.write(userDTO);
		
		System.out.println("db저장완료");

	}

}
