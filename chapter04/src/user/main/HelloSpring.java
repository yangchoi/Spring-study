package user.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import user.service.UserService;

public class HelloSpring {
	
	public void menu(ApplicationContext context) {
		Scanner scanner = new Scanner(System.in);
		UserService userService = null;
		
		while(true) {
			System.out.println();
			System.out.println("----------------");
			System.out.println("   1. 입력");
			System.out.println("   2. 출력");
			System.out.println("   3. 수정");
			System.out.println("   4. 삭제");
			System.out.println("   5. 끝");		
			System.out.println("----------------");
			System.out.print("번호를 입력하세요 : ");
			int choice = scanner.nextInt();		
			if(choice == 5) break;
			
			if(choice == 1) userService = context.getBean("userInsertService", UserService.class);
			else if(choice == 2) userService = context.getBean("userSelectService", UserService.class);
			else if(choice == 3) userService = context.getBean("userUpdateService", UserService.class);
			else if(choice == 4) userService = context.getBean("userDeleteService", UserService.class);
			else {
				System.out.println("1~5번까지만 입력가능");
				continue;
			}
	
			userService.execute();
		}		
	}
	
	public static void main(String[] args) {		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		HelloSpring helloSpring = context.getBean("helloSpring", HelloSpring.class);
		helloSpring.menu(context);
		System.out.println("프로그램을 종료합니다.");
		((AbstractApplicationContext) context).close();	
	}
}













