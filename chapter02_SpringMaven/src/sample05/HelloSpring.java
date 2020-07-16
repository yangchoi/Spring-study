package sample05;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class HelloSpring {
	public void menu(ApplicationContext context) {
		Scanner scanner = new Scanner(System.in);
		SungJuk sungJuk = null;
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
			choice = scanner.nextInt();
			
			if(choice == 5) break;
			if(choice == 1) sungJuk = context.getBean("sungJukInput", SungJuk.class);
			else if(choice == 2) sungJuk = context.getBean("sungJukOutput", SungJuk.class);
			else if(choice == 3) sungJuk = context.getBean("sungJukModify", SungJuk.class);
			else if(choice == 4) sungJuk = context.getBean("sungJukDelete", SungJuk.class);
			
			sungJuk.execute();
		}//while
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloSpring helloSpring = context.getBean("helloSpring", HelloSpring.class);
		helloSpring.menu(context);
		((AbstractApplicationContext) context).close();	
		System.out.println("프로그램을 종료합니다");
	}

}










