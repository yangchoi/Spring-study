package user.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import user.service.UserService;


public class HelloSpring {
	public void menu(ApplicationContext context) {
		Scanner scan = new Scanner(System.in);
		UserService userService = null;
		int choice;
		
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
			choice = scan.nextInt();
			
			if(choice == 5) break;
			if(choice == 1) userService = context.getBean("userInsertService", UserService.class);
			// spring을 쓰기 전이였으면 sungJuk = new SungJukInput() 이라고 했었을 것. 
			// 근데 이젠 직접 new 안하고 값을 가져온다. 
			// di injection : 외부로부터 값을 가져와서 참조를 시켜준다. 
			else if(choice == 2) userService = context.getBean("userSelectService", UserService.class);
			else if(choice == 3) userService = context.getBean("userUpdateService", UserService.class);
			else if(choice == 4) userService = context.getBean("userDeleteService", UserService.class);
			else {
				System.out.println("1에서 5까지의 숫자만 가능합니다. ");
				continue; // 다시 while문으로 올라가기 
			}
			userService.execute();
		}//while
		
		scan.close();
	}

	public static void main(String[] args) {
		/*
		 * HelloSpring helloSpring = new HelloSpring();
		 * HelloSpring.menu();
		 * System.out.println("종료");
		 * 위와 같이 new 해주지말고 application에서 선언해준다. 
		 * */
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		HelloSpring helloSpring = context.getBean("helloSpring", HelloSpring.class);
		helloSpring.menu(context);
		((AbstractApplicationContext) context).close();	
		System.out.println("프로그램을 종료합니다");
	}


}
