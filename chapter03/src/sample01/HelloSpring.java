package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("acQuickStart.xml");
		MessageBean bean = (MessageBean) context.getBean("messageBeanImpl");
		
		/*
		bean.showPrintBefore();
		System.out.println("-------------");
		bean.viewPrintBefore();
		System.out.println("-------------");
		bean.display();
		System.out.println("-------------");
		*/
		
		/*
		bean.showPrintAfter();
		System.out.println("-------------");
		bean.viewPrintAfter();
		System.out.println("-------------");
		bean.display();
		System.out.println("-------------");
		*/
		
		bean.showPrint();
		System.out.println("-------------");
		bean.viewPrint();
		System.out.println("-------------");
		bean.display();
		System.out.println("-------------");
		
	}

}









