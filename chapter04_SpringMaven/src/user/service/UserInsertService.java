package user.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

// service 쓸 시 setter 언테이션 (롬복)쓰면 안됨 
// 대신 autowired 써야한다. 
@Service
public class UserInsertService implements UserService {
	@Autowired // 같은 항목을 찾아서 사용해라 
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
